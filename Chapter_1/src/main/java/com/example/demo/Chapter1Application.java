package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**SpringBootApplication
 *      @SpringBootConfiguration:标明该类是配置类
 *      @EnableAutoConfiguration：注解启用自动配置，帮助所有springboot应用将所有符合条件的@Configuration加载到IOC容器中
 *      @ComponentScan
 * RestController
 *      @Controller
 *      @ResponseBody
 * GetMapping=@RequestMapping(method = {RequestMethod.GET})
 */
@SpringBootApplication
@RestController
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

    @GetMapping("/hello")
    public String index(){
        return "Hello World!";
    }
}
