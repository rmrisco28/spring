package com.example.spring.controller;

import com.example.spring.entity.Entity14;
import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor
public class Controller20 {
    private final Service2 service2;

    @GetMapping("sub1")
    public String sub1() {
        service2.process1();


        return "/main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service2.process2();

        return "/main20/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service2.process4();
        return "/main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4() {
        service2.process5();
        return "/main20/sub4";
    }

    @GetMapping("sub5")
    public String sub5() {
        service2.process6();
        return "/main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6() {
        service2.process6();
        return "/main20/sub6";
    }

    @GetMapping("sub10")
    public String sub10() {
        // spring DATA JPA
        // Entity: 테이블과 매핑되는 클래스(객체)
        // Repository: Entity를 이용한 CRUD 메소드 제공(클래스/interface)
        //// SELECT : find... , get ....
        //// UPDATE : save
        //// DELETE : delete...
        //// INSERT : save

        //// 선배들이 미리 만들어둔 메소드가 존재함.
        //// JpaRepository<T,ID> 인터페이스를 상속해서 만들면됨.
        //// 타입 파라미터 T: crud 대상 테이블의 매핑되는 Entity
        //// 타입 파라미터 ID: Entity의 PK 자료형(TYPE)

        //// Spring 은
        //// Repository 인터페이스에 있는 메소드 활용해서
        //// 연결 설정, statement, ResultSet 처리하는 구현 코드를 생성

        service2.process7();

        return "/main20/sub10";
    }

    @GetMapping("sub11")
    public String sub11() {
        service2.process8();
        return "/main20/sub11";
    }

    @GetMapping("sub12")
    public String sub12() {
        service2.process9();
        return "/main20/sub12";
    }

    // 연습
    // Entity13 만들고
    // Entity 13 Repository 만들기
    // request handler method, service.process10() 메소드
    // 만들어서 findById() 호출해보기 // -> 테이블 없다는 에러 보기.
    @GetMapping("sub13")
    public String sub13() {
        service2.process10();
        return "/main20/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id, Model model) {

        Entity14 data = service2.process11(id);
        model.addAttribute("data", data);
        System.out.println(data);
        return "/main20/sub14";
    }

    // /main20/sub15?name=choi&score=88&city=dokdo
    @GetMapping("sub15")
    public String sub15(String name, Double score, String city) {
        service2.process12(name, score, city);
        return "/main20/sub15";
    }

    // /main20/sub16?address=신촌&price=5000&insertedAt=2010-10-10T10:15:32
    @GetMapping("sub16")
    public String sub16(String address, Integer price, LocalDateTime insertedAt) {
        service2.process13(address, price, insertedAt);
        return "/main20/sub16";
    }

    // /main20/sub17?id=2&score=12.34
    @GetMapping("sub17")
    public String sub17(Integer id, Double score) {
        service2.process14(id, score);
        return "/main20/sub17";
    }

    // 연습
    // /main20/sub18?id=1&address=강남
    @GetMapping("sub18")
    public String sub18(Integer id, String address) {
        service2.process15(id, address);

        return "/main20/sub18";
    }


    // DELETE
    /*
    DELETE FROM my_table14
    WHERE id = ?
    */
    // /main20/sub19?id=1
    @GetMapping("sub19")
    public String sub19(Integer id) {
        service2.process16(id);

        return "/main20/sub19";
    }

    //연습
    // /main20/sub20?id=1
    // 15qjs 테이블 1번 레코드 삭제 코드 작성
    @GetMapping("sub20")
    public String sub20(Integer id) {
        service2.process17(id);
        return "/main20/sub20";
    }
}