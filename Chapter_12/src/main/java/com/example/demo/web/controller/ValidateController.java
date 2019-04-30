package com.example.demo.web.controller;

import com.example.demo.config.DateTime;
import com.example.demo.entity.Book;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @Validated： 开启数据有效性校验，添加在类上即为验证方法，添加在方法参数中即为验证参数对象。（添加在方法上无效）
 * @NotBlank： 被注释的字符串不允许为空（value.trim() > 0 ? true : false）
 * @Length： 被注释的字符串的大小必须在指定的范围内
 * @NotNull： 被注释的字段不允许为空(value ! = null ? true : false)
 * @DecimalMin： 被注释的字段必须大于或等于指定的数值
 *
 * 注解的作用，先执行注解代理的类中的验证
 */
@Validated
@RestController
public class ValidateController {
    @GetMapping("/test2")
    public String test2(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name) {
        return "success";
    }

    @GetMapping("/test3")
    public String test3(@Validated Book book) {
        return "success";
    }
    @GetMapping("/test")
    public String test(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
        return "success";
    }
}
