package com.liuzhiqiang.config.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by JJJ on 2017/2/22.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Monitor {
    String logTitle() default "";

    String logType() default "";

    String text() default "";
}