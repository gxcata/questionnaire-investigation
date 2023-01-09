package com.gxcata.questionnaireinvestigation;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.gxcata.questionnaireinvestigation.mapper")
@EnableEncryptableProperties//开启自动解密
public class QuestionnaireInvestigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireInvestigationApplication.class, args);
    }

}
