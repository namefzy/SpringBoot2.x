package com.example.demo.config;

/**
 * 锁的注解
 */

import java.lang.annotation.*;

/**
 * 锁的注解
 *
 * @author Levin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {
    String  key() default "";
    /**
     * 设置过期时间
     */
    int expire() default 5;
}
