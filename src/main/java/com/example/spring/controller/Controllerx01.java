package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.Object;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


@Controller
public class Controllerx01 {

    @RequestMapping("/main1/sub11")
    public void method1() {
        System.out.println("메소드1을 출력합니다.");
        System.out.println("Controller01.method1");
    }
    // 연습:
    // /main2/sub8?address=jeju&country=korea&city=gangnam

    @RequestMapping("/main2/sub88")
    public void method2(String address, String country, String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    // 연습: 아래 URL로 요청 올 때 적절히 처리하는 메소드 작성
    // main2/sub13?email=gmail&score=88.8&married=true
    // main2/sub14?&score=88.8&married=true
    // @RequestParam이 없으면 생략될수도 있다.
    @RequestMapping({"/main2/sub113", "/main2/sum114"})
    public void method3(
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "score", required = false, defaultValue = "") Double score,
            @RequestParam(value = "married", required = false, defaultValue = "") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }
    // 연습:
    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?city=seoul&home=jeju
    // /main2/sub17?city=seoul&age=33
    // /main2/sub17?home=jeju&age=33

    // city 기본값 ""
    // home 기본값 ""
    // age 기본값 ""

    @RequestMapping("/main2/sub117")
    public void method4(
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam(required = false, defaultValue = "") String home,
            @RequestParam(required = false, defaultValue = "") String age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }
    // 연습: 아래 URL로 요청 올 때 일하는메소드 완성
    // main2/sub20?country=korean&core=90&score80&score=70

    @RequestMapping("/main2/sub200")
    public void method5(
            String country,
            double[] score) {
        System.out.println("country = " + country);
        System.out.println("Arrays.toString(score) = " + Arrays.toString(score));
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&married=true
    @RequestMapping("/main2/sub223")
    public void method6(
            @RequestParam Map<String, Objects> params) {
        for (var a : params.entrySet())
            System.out.println(a.getKey() + " : " + a.getValue());
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=99&score=87&married=true
    // 같은 키를 중복으로 받는경우
    @RequestMapping("/main2/sub224")
    public void method7(
            @RequestParam MultiValueMap<String, Object> params) {
        for (var b : params.entrySet()) {
            System.out.println(b.getKey() + " : " + b.getValue());
        }
    }

}
