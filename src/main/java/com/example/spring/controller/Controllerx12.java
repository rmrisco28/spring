package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("preparation12")
public class Controllerx12 {

    @GetMapping("hello")
    public String sub1(Model model,
                       @RequestParam("name") String name) {
        String a = name + "님 안녕하세요";
        model.addAttribute("message", a);


        return "preparation12/hello";
    }

    @RequestMapping("sub1")
    public String sub1(String city,
                       Integer n) {

        System.out.println(city);
        System.out.println("n = " + n);

        return "preparation12/sub1";
    }

    @GetMapping("login")
    public String login(Model model) {


        return "preparation12/login";
    }

    @PostMapping("greet2")
    public String greet(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "입력한 이름: " + name);
        return "preparation12/result";
    }

}
