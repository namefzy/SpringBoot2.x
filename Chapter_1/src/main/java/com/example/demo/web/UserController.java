package com.example.demo.web;

import com.example.demo.domain.Girl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final Girl user;

    public UserController(Girl user) {
        this.user = user;
    }

    @GetMapping("/1")
    public Girl properties(){
        log.info("=================================================================================================");
        log.info(user.toString());
        log.info("=================================================================================================");
        return user;
    }
}
