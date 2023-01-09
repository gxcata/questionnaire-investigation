package com.gxcata.questionnaireinvestigation.common.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来跳过验证的PassToken 不要token验证的方法加入PassToken
 * @author wanghailun
 * @date 2022年12月28日 09:32
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}