package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controllerx02 {

    @GetMapping("/welcom")
    @ResponseBody
    public String start() {

        return "Welcome to Spring!";
    }
}
