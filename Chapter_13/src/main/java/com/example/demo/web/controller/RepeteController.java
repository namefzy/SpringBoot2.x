package com.example.demo.web.controller;

import com.example.demo.config.LocalLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对于AOP的理解
 *
 * 简单来说，
 *
 *       <!-- 配置Bean -->
 *      <bean id ="CalculationImpl" class="biz.CalculationImpl"></bean>
 *      <!-- 将切面类交与Spring容器管理 -->
 *      <bean class="advice.CalculationAnnotation"></bean>
 *       <!-- 使用注解自动生成代理对象 -->
 *       <aop:aspectj-autoproxy/>z
 *
 *
 *
 */
@RestController
@RequestMapping
public class RepeteController {
    @LocalLock(key = "book:arg[0]")
    @GetMapping("aspect")
    public String query(@RequestParam String token){
        return "success -"+token;
    }
}
