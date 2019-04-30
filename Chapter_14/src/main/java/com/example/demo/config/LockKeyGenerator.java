package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class LockKeyGenerator implements CacheKeyGenerator{
    @Override
    public String getLockKey(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        CacheLock annotation = method.getAnnotation(CacheLock.class);
        Object[] args = proceedingJoinPoint.getArgs();
        Parameter[] parameters = method.getParameters();
        StringBuilder builder = new StringBuilder();
        //默认解析方法里面带CacheParam注解的属性，如果没有尝试着解析实体对象中的
        for (int i=0;i<parameters.length;i++){
            CacheParam annotation1 = parameters[i].getAnnotation(CacheParam.class);
            if(annotation1 == null){
                continue;
            }
            builder.append(annotation.delimiter()).append(args[i]);
        }
        if(StringUtils.isEmpty(builder.toString())){
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i <parameterAnnotations.length ; i++) {
                Object object = args[i];
                Field[] fields = object.getClass().getDeclaredFields();
                for(Field field:fields){
                    CacheParam annotation1 = field.getAnnotation(CacheParam.class);
                    if(annotation1==null){
                        continue;
                    }
                    field.setAccessible(true);
                    builder.append(annotation.delimiter()).append(ReflectionUtils.getField(field,object));
                }
            }
        }
        return annotation.prefix()+builder.toString();
    }
}
