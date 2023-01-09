package com.gxcata.questionnaireinvestigation.common.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * @author wanghailun
 * @date 2022年06月28日 11:33
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();

// 1允许任何域名使用

        corsConfiguration.addAllowedOrigin("*");

// 2允许任何头

        corsConfiguration.addAllowedHeader("*");

// 3.允许ajax异步请求带cookie信息

        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));

// 4允许任何方法(post、get等)

        corsConfiguration.addAllowedMethod("*");

        return corsConfiguration;

    }
    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", buildConfig());

        return new CorsFilter(source);

    }

}


