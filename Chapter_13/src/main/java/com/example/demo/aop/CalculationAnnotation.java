package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Aspect
@Configuration
public class CalculationAnnotation {
    /**
     * 定义前置通知
     * execution(* biz.UserBiz.*(..)) 表示  所有修饰符的所有返回值类型  biz.UserBiz 包下的所有方法
     * 在方法执行之前执行
     * */
    @Before("execution(* com.example.demo.aop..CalculationImpl.*(..))")
    public void before(JoinPoint join){
        //获取方法名
        String mathName=join.getSignature().getName();
        //获取参数列表
        List<Object> args = Arrays.asList(join.getArgs());

        System.out.println("前置通知---->before   方法名是:"+mathName+"\t参数列表是:"+args);
    }

    /**
     * 后置通知
     * 在方法返回后执行，无论是否发生异常
     * 不能访问到返回值
     *
     * */
//    @After("execution(* biz.CalculationImpl.*(..))")
//    public void after(){
//        System.out.println("后置通知---->after....");
//    }
}
