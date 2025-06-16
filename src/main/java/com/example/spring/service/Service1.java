package com.example.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class Service1 {
    public String action1() {
        System.out.println("crud 작업. business logic 실행");
        return "결과값";
    }
}
