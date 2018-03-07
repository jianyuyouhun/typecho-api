package com.jianyuyouhun.typechoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloGet() {
        return "get boot";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "post boot";
    }
}
