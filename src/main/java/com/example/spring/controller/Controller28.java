package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/main28")
@ResponseBody
public class Controller28 {

    @GetMapping("sub1")
    public String sub1() {
        System.out.println("Controller28.sub1");

        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller28.sub2");

        return null;
    }

    @GetMapping("sub3")
    public String sub3() {
        System.out.println("Controller28.sub3");

        return null;
    }

    @PostMapping("sub4")
    public String sub4() {
        System.out.println("Controller28.sub4");
        return null;
    }

    @GetMapping("sub6")
    public String sub6() {
        System.out.println("Controller28.sub6");
        return null;
    }

    @GetMapping("sub7")
    public String sub7() {
        System.out.println("Controller28.sub7");
        return null;
    }

    @GetMapping("sub8")
    public String sub8(String name, Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println();
        return null;
    }

    // 연습: react에서 아래 메소드가 일할 수 있도록 9번째 메소드 만들고 클릭
    @GetMapping("sub9")
    public String sub9(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println();
        return null;
    }

    @GetMapping("sub10")
    public String sub10(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println();
        return null;
    }

    @GetMapping("sub11")
    public String sub11(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println();
        return null;
    }

    // 연습: 아래 메소드가 일하도록 react 12번째 버튼 만들고 클릭
    // config.params 활용
    @GetMapping("sub12")
    public String sub12(String fruit, Integer price) {
        System.out.println("fruit = " + fruit);
        System.out.println("price = " + price);
        System.out.println();
        return null;
    }

    @GetMapping("sub13")
    public String sub13(String name, Integer age, String address) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
        System.out.println();
        return null;
    }

    // 연습: react에서 14번째 버튼 만들고 클릭, 아래 메소드가 일하도록
    // URL SearchParams 객체 활용
    @GetMapping("sub14")
    public String sub14(String city, String country, Integer id) {
        System.out.println("city = " + city);
        System.out.println("country = " + country);
        System.out.println("id = " + id);
        System.out.println();
        return null;
    }

    @GetMapping("sub15")
    public String sub15(String name, Integer age, String country) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("country = " + country);
        System.out.println();
        return null;
    }

    // 연습: 아래 메소드가 일하도록
    // react 16번째 버튼 만들고 클릭
    // URLSearchParams 객체를 주소 뒤에 문자열 연결 연산으로 붙이기
    @GetMapping("sub16")
    public String sub16(String fruit, Integer price, String location) {
        System.out.println("fruit = " + fruit);
        System.out.println("price = " + price);
        System.out.println("location = " + location);
        System.out.println();
        return null;
    }

    @GetMapping({"sub17", "sub18", "sub19", "sub20"})
    public String sub17(String name, Integer age, String city) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("city = " + city);
        System.out.println();
        return null;
    }

    // 연습: react 4개의 버튼과 input 3개, useState *3 를 작성해서
    // 각 버튼 클릭시 아래 메소드가 일 할 수있도록 코드 작성
    // sub21 : 쿼리스트링 직접 작성
    // sub22 : URLSearchParams 객체를 url에 연결 연산으로 붙이기
    // sub23 : config.params 값을 URLSearchParams로 주기
    // sub24 : config.params 값을 객체로 주기
    @GetMapping({"sub21", "sub22", "sub23", "sub24"})
    public String sub21(String fruit, Integer price, String location) {
        System.out.println("fruit = " + fruit);
        System.out.println("price = " + price);
        System.out.println("location = " + location);
        System.out.println();
        return null;
    }
}
