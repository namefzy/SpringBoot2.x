package com.example.demo.test;

import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 通过扫描 创建<beans></>工厂
 * @Bean:可以配置bean生命周期，可以配置bean为单例还是多例，在方法上默认匹配以方法名开头的实体实例化
 * */
@Configuration
public class UserConfig {
    public UserConfig(){
        System.out.println("beans");
    }
    @Bean
    public static User user(){
        return new User();
    }
}
