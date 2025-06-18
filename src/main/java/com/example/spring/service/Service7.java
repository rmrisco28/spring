package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {
    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;
    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

    public void action1() {
        Entity27 o1 = new Entity27();
        Entity27 o2 = new Entity27();
        Entity27 o3 = new Entity27();

        o1.setCategory_name("음료수");
        o2.setInfo("설탕물");
        o3.setCategory_name("전자제품");

        o1.setInfo("전기를 사용하는 물건");
        o2.setCategory_name("청소용품");
        o3.setInfo("청소할때 사용하는 물건");
        entity27Repository.<Entity27>save(o1);
        entity27Repository.<Entity27>save(o2);
        entity27Repository.<Entity27>save(o3);


    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1상");
        p6.setUnit("1대");

        // 이때 entity27의 값을 조회해서 채워야함
        Entity27 o1 = entity27Repository.findById(1).get();
        Entity27 o2 = entity27Repository.findById(2).get();
        Entity27 o3 = entity27Repository.findById(3).get();

        p1.setCategory(o3);
        p2.setCategory(o2);
        p3.setCategory(o1);
        p4.setCategory(o2);
        p5.setCategory(o3);
        p6.setCategory(o3);

        entity28Repository.<Entity28>save(p1);
        entity28Repository.<Entity28>save(p2);
        entity28Repository.<Entity28>save(p3);
        entity28Repository.<Entity28>save(p4);
        entity28Repository.<Entity28>save(p5);
        entity28Repository.<Entity28>save(p6);
    }

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);
    }

    public void action4(Integer id) {
        Entity28 entity28 = entity28Repository.findById(id).get();
        System.out.println("entity28 = " + entity28);
    }

    public void action5() {
        // 직원 정보를 입력
        Entity29 o1 = new Entity29();
        Entity29 o2 = new Entity29();
        Entity29 o3 = new Entity29();

        o1.setFirstName("kim");
        o2.setFirstName("park");
        o3.setFirstName("choi");

        o1.setLastName("철수");
        o2.setLastName("영희");
        o3.setLastName("똘이");

        o1.setBirthDate(LocalDate.parse("1990-01-01"));
        o2.setBirthDate(LocalDate.parse("1990-01-02"));
        o3.setBirthDate(LocalDate.parse("1990-01-03"));

        entity29Repository.save(o1);
        entity29Repository.save(o2);
        entity29Repository.save(o3);
        // 한번에 저장도 가능
        // entity29Repository.saveAll(List.of(o1, c2, c3));oo3
    }

    public void action6() {
        // 주문 정보를 입력
        Entity30 o1 = new Entity30();
        Entity30 o2 = new Entity30();
        Entity30 o3 = new Entity30();
        Entity30 o4 = new Entity30();
        Entity30 o5 = new Entity30();
        Entity30 o6 = new Entity30();

        o1.setInfo("김밥");
        o2.setInfo("초밥");
        o3.setInfo("주먹밥");
        o4.setInfo("콜라");
        o5.setInfo("사이다");
        o6.setInfo("탄산수");

        o1.setOrderDate(LocalDate.parse("2090-01-01"));
        o2.setOrderDate(LocalDate.parse("2090-01-02"));
        o3.setOrderDate(LocalDate.parse("2090-01-03"));
        o4.setOrderDate(LocalDate.parse("2090-01-04"));
        o5.setOrderDate(LocalDate.parse("2090-01-05"));
        o6.setOrderDate(LocalDate.parse("2090-01-06"));

        // 조회를 먼저 하고
        Entity29 e1 = entity29Repository.findById(1).get();
        Entity29 e2 = entity29Repository.findById(2).get();
        Entity29 e3 = entity29Repository.findById(3).get();
        // 조회한 값 넣기
        o1.setEmployee(e3);
        o2.setEmployee(e1);
        o3.setEmployee(e2);
        o4.setEmployee(e3);
        o5.setEmployee(e1);
        o6.setEmployee(e2);

        // 저장
//        entity30Repository.save(o1);
//        entity30Repository.save(o2);
//        entity30Repository.save(o3);
//        entity30Repository.save(o4);
//        entity30Repository.save(o5);
//        entity30Repository.save(o6);
        entity30Repository.saveAll(List.of(o1, o2, o3, o4, o5, o6));
    }

    public void action7(Integer id) {
        Entity29 entity29 = entity29Repository.findById(id).get();
        System.out.println("entity29 = " + entity29);
    }

    public void action8(Integer id) {
        Entity30 entity30 = entity30Repository.findById(id).get();
        System.out.println("entity30 = " + entity30);
    }

    public void action9(Integer id) {
        Entity30 o = entity30Repository.findById(id).get();

        // 29번 테이블과 관련 없을 때는 조회 하지 않는다.
        System.out.println("o.getOrderDate() = " + o.getOrderDate());
        System.out.println("o.getInfo() = " + o.getInfo());

        // 직원정보
        System.out.println("o.getEmployee().getLastName() = " + o.getEmployee().getLastName());
    }
}
