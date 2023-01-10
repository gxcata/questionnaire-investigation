package com.gxcata.questionnaireinvestigation.common.jwt;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum;
import com.gxcata.questionnaireinvestigation.entity.CUser;
import com.gxcata.questionnaireinvestigation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author wanghailun
 * @date 2022年12月28日 11:12
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        AuthenticationInterceptor.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object){
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    //"无token，请重新登录"!
                    throw new RRException(ErrorCodeEnum.ERROR_TOKEN);
                }
                // 获取 token 中的 phone
                String phone;
                try {
                    phone = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RRException(ErrorCodeEnum.ERROR_TOKEN);
                }

                CUser user = userService.queryUserByPhone(phone);
                if (user == null || ObjectUtil.isEmpty(user)) {
                    throw new RRException(ErrorCodeEnum.ERROR_TOKEN);
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TokenUtils.TOKEN_SECRET)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RRException(ErrorCodeEnum.ERROR_TOKEN);
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}

