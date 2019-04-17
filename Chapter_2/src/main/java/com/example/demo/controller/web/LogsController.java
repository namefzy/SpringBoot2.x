package com.example.demo.controller.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {

    @GetMapping("/log")
    public String index(){
        return "1234";
    }
}
