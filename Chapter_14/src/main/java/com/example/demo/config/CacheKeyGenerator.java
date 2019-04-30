package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * key生成器1
 */
public interface CacheKeyGenerator {
    /**
     * 获取aop参数，生成指定缓存key
     */
    String getLockKey(ProceedingJoinPoint proceedingJoinPoint);
}
