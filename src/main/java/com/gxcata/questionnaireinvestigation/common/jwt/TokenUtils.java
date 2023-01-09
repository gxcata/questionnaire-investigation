package com.gxcata.questionnaireinvestigation.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gxcata.questionnaireinvestigation.entity.CUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月27日 11:30
 */
@Slf4j
public class TokenUtils {
    /**
     *
     设置过期时间为24个小时
     */
    private static final Long EXPIRE_TIME = 24*60*60*1000L;

    /**
     * 生成 TOKEN 的密钥 注意 TOKEN都是根据该密钥组合加密进行生成的
     */
    public static final String TOKEN_SECRET =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4g";

    /**
     * 生成 Token
     * @param user
     * @return
     */
    public static String sign(CUser user){
        String token = null;
        try {
            Date expire = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withAudience(user.getPhoneNumber())
                    .withClaim("userId",user.getUserId())
                    //过期时间
                    .withExpiresAt(expire)
                    //存放数据
                    .withClaim("userName",user.getUserName())
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        }catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常 我们需要在拦截器调用这个方法，捕获异常，然后返回错误信息给前端
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
        return decodedJWT;
    }

    /**
     * 获取token中的 payload 也就是第二部分的信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
        //使用 TokenUtils.getTokenInfo(token).getClaim("account").asString()
        return decodedJWT;
    }

    /**
     * 根据当前登录用户token获取userId
     */
    public static String getUserId(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT tokenInfo = getTokenInfo(token);
        String userId = tokenInfo.getClaim("userId").asString();
        return userId;
    }
}
