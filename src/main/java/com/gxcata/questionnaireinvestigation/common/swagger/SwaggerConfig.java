package com.gxcata.questionnaireinvestigation.common.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wanghailun
 * @date 2022年06月21日 16:52
 */

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {
    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("gxcata问卷调查接口文档",
                "问卷调查",
                "1.0.0",
                "API TERMS URL",
                "923475374@qq.com",
                "license",
                "license url");
        return apiInfo;
    }
}
