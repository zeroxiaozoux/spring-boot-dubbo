package com.zero.core.config;

import java.lang.annotation.*;

/**
 * @author zero
 * @date 2020/8/26-18:03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface LogAnnotation {
    /**
     * 是否打印接口出参
     */
    boolean logResult() default true;
}
