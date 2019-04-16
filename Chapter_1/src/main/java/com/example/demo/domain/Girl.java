package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  注解
 *  @ConfigurationProperties配置属性值=@Value注解
 *  @PropertySource自动加载对应位置的配置文件属性
 */
@Component
@PropertySource("classpath:application1.properties")
@ConfigurationProperties(prefix = "gril")
public class Girl {
//    @Value("${user.age}")
    private int age;
//    @Value("${user.name}")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
