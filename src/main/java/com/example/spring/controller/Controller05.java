package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public String sub1(Model model) {
        model.addAttribute("name", "son");
        // attribute 가 java Beans(DTO)
        MyBean051 m = new MyBean051();
        m.setAge(20);
        m.setAddress("seoul");
        m.setName("trump");

        model.addAttribute("obj", m);
        // forward to / templates/main5/sub1
        return "/main5/sub1";
    }

    // 연습 아래 코드를 보고 나머지 코드들 (dto, html)을 완성하세요
    @RequestMapping("sub2")
    public String sub2(Model model) {
        MyBean052 obj = new MyBean052();
        obj.setHome("ny");
        obj.setScore(98.76);
        obj.setHeight(180.5);
        obj.setNickName("tiger");
        //  꺼낼때 "attr"로 꺼낼 수 있도록 설정되어있다.
        model.addAttribute("attr", obj);

        return "main5/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        MyBean053 a = new MyBean053();
        a.setWeight(60.5);
        a.setInfo("가나다라");
        a.setStudentNumber(123);
        a.setMarried(false);

        // 꺼낼때 val로
        model.addAttribute("val", a);
        return "main5/sub3";
    }

    // model attribute tyep 이 Map
    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("attr",
                Map.of("name", "tiger",
                        "age", 20,
                        "address", "seoul",
                        "1 my info", "my name is trump"));

        return "main5/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("values", Map.of(
                "home", "제주",
                "address", "애월",
                "birth data", "2010-01-01",
                "score", 98.76
        ));

        return "main5/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("car", Map.of(
                "model", "제네시스",
                "company", "현대",
                "price", 55_000_000,
                "used", "musk",
                "pre user", "ilon"
        ));
        return "main5/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("list", new String[]{"java", "css", "react", "vue"});

        return "main5/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("skill", new String[]{"bootstrap", "thymeleaf", "react"});
        return "main5/sub8";
    }

    @RequestMapping("sub9")
    public String sub9(Model model) {
        model.addAttribute("list", List.of("tesla", "waymo", "volvo", "bmw"));

        return "main5/sub9";
    }

    @RequestMapping("sub10")
    public String sub10(Model model) {
        MyBean054 o = new MyBean054("trump", 77, List.of("1234", "5678", "0987"));
        model.addAttribute("president", o);

        return "main5/sub10";
    }

    @RequestMapping("sub11")
    public String sub11(Model model) {
        MyBean055 a = new MyBean055(12, List.of("seoul", "jeju"), List.of("samsung", "hyndae"));
        model.addAttribute("person", a);
        return "main5/sub11";
    }

    @RequestMapping("sub12")
    public String sub12(Model model) {
        model.addAttribute("people", List.of(
                new MyBean056("tesla", 66, true),
                new MyBean056("apple", 77, false),
                new MyBean056("uber", 88, true)
        ));
        return "main5/sub12";
    }

    // 연습
    // 아래 코드가 동작해서 html에서 적절한 값들을 출력되도록 하세요
    @RequestMapping("sub13")
    public String sub13(Model model) {

        model.addAttribute("aiList",
                List.of(new MyBean057("gemini", "2020-01-01",3000),
                        new MyBean057("chatgpt", "191-1212",3500),
                        new MyBean057("calude", "1998-11-11",6000)));

        return "main5/sub13";
    }
}
