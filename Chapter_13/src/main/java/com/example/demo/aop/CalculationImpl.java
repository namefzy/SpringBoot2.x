package com.example.demo.aop;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculationImpl implements Calculation {
    @Override
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }
}
