package com.example.spring.controller;

import com.example.spring.service.Service3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("main21")
public class Controller21 {

    private final Service3 service3;

    @GetMapping("sub1")
    public String sub1() {

        service3.action1();

        return "main21/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service3.action2();
        return "main21/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service3.action3();

        return "main21/sub3";
    }

    // /main21/sub4?country=mexico
    @GetMapping("sub4")
    public String sub4(String country) {
        service3.action4(country);

        return "main21/sub4";
    }

    // 연습
    // get /main21/sub5?city=berlin
    // service3.action5()
    // entity16Repository.query2()

    @GetMapping("sub5")
    public String sub5(String city) {
        service3.action5(city);

        return "main21/sub5";
    }

    // 두개의 파라미터를 받는 query 작성 하기
    // get /main21/sub6?city1=berlin&city2=london
    @GetMapping("sub6")
    public String sub6(String city1, String city2) {
        service3.action6(city1, city2);
        return "main21/sub6";
    }

    // get /main21/sub7?start=1950-01-01&end=1959-12-31
    // controller.sub7()
    // service.action7()
    // entity17.repository.query1()
    // SELECT FROM employee WHERE birth_date BETWEEN : start And :end

    @GetMapping("sub7")
    public String sub7(LocalDate start, LocalDate end) {
        service3.action7(start, end);
        return "main21/sub7";
    }

    // get /main21/sub8?keyword=fred
    //  이름에 fred가 있는 고객 조회
    @GetMapping("sub8")
    public String sub8(String keyword) {
        service3.action8(keyword);
        return "main21/sub8";
    }
    // get /main21/sub8?keyword=an
    // 직원 이름에 an이 있는 직원들조회
    // controller.sub9()
    // service.action9()
    // entity17Repository.query2()

    @GetMapping("sub9")
    public String sub9(String keyword) {
        service3.action9(keyword);
        return "main21/sub9";
    }

    @GetMapping("sub10")
    public String sub10(String country) {
        service3.action10(country);
        return "main21/sub10";
    }

    @GetMapping("sub11")
    public String sub11(String city) {
        service3.action11(city);
        return "main21/sub11";
    }

    @GetMapping("sub12")
    public String sub12(String keyword) {
        service3.action12(keyword);
        return "main21/sub12";
    }

    // 연습
    // 직원 검색 로직
    @GetMapping("sub13")
    public String sub13(String keyword) {
        service3.action13(keyword);
        return "main21/sub13";
    }

    @GetMapping("sub14")
    public String sub14(String country) {
        service3.action14(country);
        return "main21/sub14";
    }

    @GetMapping("sub15")
    public String sub15(String city) {
        service3.action15(city);
        return "main21/sub15";
    }

    @GetMapping("sub16")
    public String sub16(LocalDate start, LocalDate end) {
        service3.action16(start, end);
        return "main21/sub16";
    }

    @GetMapping("sub17")
    public String sub17() {
        service3.action17();
        return "main21/sub17";
    }

    @GetMapping("sub18")
    public String sub18() {
        service3.action18();

        return "main21/sub18";
    }

    @GetMapping("sub19")
    public String sub19() {
        service3.action19();

        return "main21/sub19";
    }

    @GetMapping("sub20")
    public String sub20() {
        service3.action20();
        return "main21/sub20";
    }
}
