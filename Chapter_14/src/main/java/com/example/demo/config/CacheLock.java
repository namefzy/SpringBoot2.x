package com.example.demo.config;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {
    /**
     * redis 锁key的前缀
     */
    String prefix() default "";
    /**
     * 过期秒数，默认为5秒
     */
    int expire() default 5;
    /**
     *超时单位时间
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * key的分隔符
     */
    String delimiter() default ":";
}
