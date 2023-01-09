package com.gxcata.questionnaireinvestigation.common.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月28日 11:38
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathLists= new ArrayList<>();
        //注册、登录允许访问，不进行拦截
        excludePathLists.add("/user/login");
        excludePathLists.add("/user/register");
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathLists);
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
