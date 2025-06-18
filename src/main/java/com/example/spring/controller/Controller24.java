package com.example.spring.controller;

import com.example.spring.service.Service6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main24")
public class Controller24 {
    private final Service6 service6;

    // get /main24/sub1?name=park&address=jeju
    @GetMapping("sub1")
    public String sub1(String name, String address) {
        service6.action1(name, address);
        return "main24/sub1";
    }
}
