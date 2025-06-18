package com.example.spring.controller;

import com.example.spring.service.Service5;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("main23")
public class Controller23 {
    private final Service5 service5;

    // /main23/sub1?page=1
    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page) {
        service5.action1(page);
        return "main23/sub1";
    }

    // /main23/sub2?country=mexico 을 하고 싶을 땐?
    @GetMapping("sub2")
    public String sub2(String country) {
        service5.action2(country);
        return "main23/sub2";
    }

    // /main23/sub2?country=mexico&page=1
    @GetMapping("sub3")
    public String sub3(String country,
                       @RequestParam(defaultValue = "1") Integer page) {
        service5.action3(country, page);
        return "main23/sub3";
    }

    // 연습
    // get /main23/sub4?keyword=ed&page=2
    // 고객명 또는 고객의 계약명에 "ed"가 포함된 고객들 조회 with paging
    // Request handler method, service.action4(), repository 메소드
    @GetMapping("sub4")
    public String sub4(String keyword, @RequestParam(defaultValue = "1") Integer page) {
        service5.action4(keyword, page);

        return "main23/sub4";
    }

    // /main23/sub5?id=1
    // 참고: 지울 때 post(delete) method 사용, 지금 교육 편의상 get method사용
    @GetMapping("sub5")
    public String sub5(Integer id) {
        service5.action5(id);
        return "main23/sub5";
    }

    // /main23/sub6?country=mexico 는 지우겠다.
    // 는 나중에 다시 설명
    @GetMapping("sub6")
    public String sub6(String country) {
        service5.action6(country);
        return "main23/sub6";
    }

    // A, B 500원 업무 옮기는게 하나의 트랜잭션이다. 라고 한적이 있음
    // 익셉션이나면 둘다 실패, 아니면 성공
    @GetMapping("sub7")
    public String sub7() {
        service5.action7();
        return "main23/sub7";
    }

    // /main23/sub8
    @GetMapping("sub8")
    public String sub8() {
        service5.action8();
        return "main23/sub8";
    }

    // 연습
    // /get /main23/sub9?country=germany
    // supplier 테이블의 국가가 germany 인 공급자 삭제하는 로직 완성
    // request handler method, service.action9, repository.deleteByCountry

    @GetMapping("sub9")
    public String sub9(String country) {
        service5.action9(country);
        return "main23/sub9";
    }

    // /main23/sub10?country=usa
    @GetMapping("sub10")
    public String sub10(String country) {
        // 국가가 usa 인 모든 고객 지우기
        service5.action10(country);
        return "main23/sub10";
    }

    // 연습
    // /main23/sub11?country=usa
    // usa인 모든 공급자 지우는 로직 완성
    @GetMapping("sub11")
    public String sub11(String country) {
        service5.action11(country);
        return "main23/sub11";
    }
}
