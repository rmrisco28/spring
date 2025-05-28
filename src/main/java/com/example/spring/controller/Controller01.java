package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller // annotation 하면 행동을 실행함
public class Controller01 {

    // RequestMapping: path에 해당하는 메소드
    @RequestMapping(path = "/main1/sub1") // main/sub1에 오면 아래 메소드를 실행하겠다
    public void method1() {
        System.out.println("Controller01.method1");
    }

    @RequestMapping(value = "/main1/sub2") // main/sub1에 오면 아래 메소드를 실행하겠다
    public void method2() {
        System.out.println("Controller01.some2");
    }

    @RequestMapping("/main1/sub3") // main/sub1에 오면 아래 메소드를 실행하겠다
    public void method3() {
        System.out.println("Controller01.some3");
    }

    // /main1/sub4 요청이 올경우
    // 실행되는 method4를작서하세요
    @RequestMapping({"/main1/sub4", "/main1/sub5"})
    public void method4() {
        System.out.println("Controller01.some4");
    }

    // WebRequest:  요청 정보가 담기는 객체의 타입
    @RequestMapping("/main1/sub6")
    public void method6(WebRequest request) {
        String s = request.getHeader("user-agent");
        String t = request.getHeader("Accept");
        System.out.println(s);
        System.out.println(t);
        System.out.println("Controller01.some6");
    }

}
