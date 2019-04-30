package com.example.demo.web.controller;

import com.example.demo.config.CacheLock;
import com.example.demo.config.CacheParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockController {
    @CacheLock(prefix = "books")
    @GetMapping("books")
    public String query(@CacheParam(name = "token") @RequestParam String token){
        return "success - " + token;
    }
}
