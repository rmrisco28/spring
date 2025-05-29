package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("main3") // 모든 메소드의 경로 앞에 부분 적용
public class Controller03 {

    // http://localhost:8080/main3/sub1

    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("controller03.sub1");
    }

    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("controller03.sub2");
    }

    // 연습 ( 클래스에 main 경로 매핑 후)
    // /main3/sub3 요청 올때 일하는 메소드 작성

    @RequestMapping("sub3")
    public void method3() {
        System.out.println("controller03.sub3");
    }

    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    // /main3/sub5?address=seoul&age=44&email=gmail&hoem= dokdo&city=ny&name=donald

    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // request parameter를 java beans으로 받기 DTO(Dta Transaction Object)
    // /main3/sub6?name=donald&address=la
    // /main3/sub6?name=trump ///만 줬을경우 address는 null
    // /main3/sub6?address=la ///만 줬을경우 name은 null
    @RequestMapping("sub6")
    public void sub6(MyBean031 params) { //bean에 name과 address가 들어있는 상황 
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress() = " + params.getAddress());
    }

    // 연습:
    // /main3/sub7?name=musk&company=tesla&home=texas
    // /main3/sub7?name=musk&company=tesla&home=texas&age=55
    // MyBean032 javaBean(dto)만들어서 request parameter 받기
    @RequestMapping("sub7")
    public void sub7(MyBean032 params) {
        System.out.println(params); // toString으로 바로 출력 가능
//        System.out.println("params.getName() = " + params.getName());
//        System.out.println("params.getCompany() = " + params.getCompany());
//        System.out.println("params.getHome() = " + params.getHome());
//        System.out.println("params.getAge() = " + params.getAge());
    }

    // /main3/sub8?nickName=trump&age=89&adress=ny&score=99.93
    @RequestMapping("sub8")
    public void sub8(MyBean033 params) {
        System.out.println(params);
    }

    // /main3/sub9?address=seoul&salary=50.5
    @RequestMapping("sub9")
    public void sub9(Mybean035 params) {
        System.out.println(params);
    }

    // /main3/sub10?age=44&email=gmail&&married=true&salary=40.4&name=donald
    // 요청 파라미터 받는 MyBean036 클래스 만들고
    // 메소드 작성 (정확한 이름: request handler method)
    @RequestMapping("sub10")
    public void sub10(MyBean036 param) {
        System.out.println(param);
    }


    // /main3/sub11?name=donald&address=ny&pw=1234 // 불가능
    // /main3/sub11?name=donald&address=ny&password=1234 // 가능

    // request parameter와 같은 이름의 setter 메소드 사용.
    //

    @RequestMapping("sub11")
    public void sub11(MyBean037 param) {
        System.out.println("param = " + param);
    }

    // /main3/sub12?name=donald&age=66&skill=work&skill=basball&skill=java&skill=css
    @RequestMapping("sub12")
    public void sub12(MyBean0310 param) {
        System.out.println(param);
    }

    // 연습
    // /main3/sub13?hobby=cook&hobby=walk&hobby=running&score=3.3&score=4.4&score=5.5
    // dto(MyBean0311) 와 request handler method 만들기
    @RequestMapping("sub13")
    public void sub13(Mybean0311 param, Double[] score) {
        System.out.println("param = " + param);
        System.out.println(Arrays.toString(score));

    }
}
