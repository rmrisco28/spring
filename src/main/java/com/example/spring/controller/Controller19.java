package com.example.spring.controller;

import com.example.spring.service.Service1;
import com.example.spring.service.Service2;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main19")
@RequiredArgsConstructor
public class Controller19 {

    private final Service1 service1;


    @GetMapping("sub1")
    public String sub1(Model model) {
        // 1. 요청 받고/ 가공
        // 2. crud
        // 2.1 jdbc 연결
        // 2.2 statement 얻고
        // 2.3 쿼리 실행
        // 2.4 result set 처리
        String result = service1.action1();


        //을 서비스에게 맡긴다.

        // 3. 모델에 결과 넣고
        model.addAttribute("data", result);
        // 4. forward

        return "main19/sub1"; // exception
    }
}
// 연습
// 아래 두 클래스 만들고
// DI
// Controller20
// Service1

//request handler method 만들고
// service2의 process1() 메소드 호출하기

