package com.example.demo;

import com.example.demo.config.CacheKeyGenerator;
import com.example.demo.config.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * java.lang.ClassNotFoundException: org.apache.commons.pool2.impl.GenericObjectPoolConfig
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }

}
