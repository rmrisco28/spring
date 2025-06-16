package com.example.spring.service;

import com.example.spring.entity.*;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor // final 필드에서 자동으로 초기화하는 생성자 생성 어노테이션
public class Service2 {

    private final Entity1Repository entity1Repository;
    // 클래스를 직접 만들지 않고 자동으로 만들어준다.
    // 객체를 만들어서 주입을 해준다.
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;
    private final Entity4Repository entity4Repository;
    private final Entity5Repository entity5Repository;
    private final Entity10Repository entity10Repository;
    private final Entity11Repository entity11Repository;
    private final Entity12Repository entity12Repository;
    private final Entity13Repository entity13Repository;
    private final Entity14Repository entity14Repository;
    private final Entity15Repository entity15Repository;


    public String process1() {
        System.out.println("실제 업무 로직 (business logic, crud");
        return "결과값";
    }

    public void process2() {
        // business logic 에만 집중하고 싶다.
        // crud
        // insert, update, select, delete를
        // spring 에서 제공해주는 데이터에서 처리해주면 좋겠다.
        // spring data jpa 를 사용해서 crud
        Entity1 res = entity1Repository.findById(1).get();
        System.out.println(res.getId());
        System.out.println(res.getName());
        System.out.println(res.getAddress());
        System.out.println(res.getCity());


        // 맨처음 할일


    }

    // jap 사용을 위해
    // 두가지가 필요함
    // 1. Entity

    /// / : table과 1:1 매칭되는 클래스
    /// / : 이 클래스로 만든 각 객체는 table의 각 행과 매치됨
    /// / 테이블 안에 100개의 객체
    /// / : @Entity, @Table(클래스-테이블)  클래스와 테이블을 연결해주는 어노테이션
    /// / : @Column(클래스 필드와 - 테이블 컬럼) 클래스 필드와 테이블 컬럼을 연결해주는 테이블 컬럼
    /// / : @id(클래스 필드 - 테이블 PK) 필수로 필요한 어노테이션


    // 2. Repository
    public void process3() {
        Entity2 data = entity2Repository.findById(2).get();
        System.out.println(data);
    }

    // 연습
    // my_table3과 매핑되는 Entity3만들어보기
    // table 만들기

    public void process4() {
        Entity3 data = entity3Repository.findById(1).get();
        System.out.println(data);
    }

    public void process5() {
        Entity4 res = entity4Repository.findById(1).get();

        System.out.println(res);
    }

    public void process6() {
        Entity5 entity5 = entity5Repository.findById(1).get();
        System.out.println(entity5);
    }

    public void process7() {
        // findById: 키(id)로 하나의 record(row)를 조회함.
        // key의 값을 아래 ()안에 넣어야 하는것.
        /*
        SELECT *
        FROM my_table10
        WHERE id = 1 */
        // 조회 결과가 있으면
        Optional<Entity10> data = entity10Repository.findById(1);
        System.out.println(data.isPresent()); //false
        System.out.println(data.isEmpty()); //true

    }

    // 연습
    // entity11Repository.findById()를 사용해서 하나의 record를 조회하는
    // process8 메소드 작성
    // Controller에 request handler method
    public void process8() {
        Optional<Entity11> data = entity11Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());

    }

    public void process9() {
        Optional<Entity12> data = entity12Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());

    }

    public void process10() {
        Optional<Entity13> byId = entity13Repository.findById(1);
        System.out.println(byId.isPresent());
        System.out.println(byId.isEmpty());

    }

    public Entity14 process11(Integer id) {

        // SELECT:
        // findById(key): key에 해당하는 record를 저장한 entity 객체를 리턴(Optional)
        Optional<Entity14> data = entity14Repository.findById(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;
    }

    public void process12(String name, Double score, String city) {
        // INSERT:
        // save(): 해당 entity를 새 record로 입력
        //          해당 entity에 매핑되는 record 를 업데이트
        Entity14 data = new Entity14();
        data.setName(name);
        data.setScore(score);
        data.setCity(city);
        entity14Repository.save(data);
    }

    // table, entity, repository

    // 연습
    //save 메소드 활용하는 코드 작성해보기
    // repository, service 메소드, controller의 메소드
    public void process13(String address, Integer price, LocalDateTime insertedAt) {
        Entity15 data = new Entity15();
        data.setAddress(address);
        data.setPrice(price);
        data.setInsertedAt(insertedAt);
        entity15Repository.save(data);
    }

    public void process14(Integer id, Double score) {
        // 1. 조회하고
        Entity14 data = entity14Repository.findById(id).get();
        /* 같은 내용
        Optional<Entity14> byId = entity14Repository.findById(1);
        Entity14 entity14 = byId.get();*/

        // 꼭 조회하고 값을 변경해야한다.
        // 그렇지 않으면, 다른 값도 같이 변경됨.

        // 2. 값 변경
//        data.setName("강");
        data.setScore(score);

        // 3. save
        entity14Repository.save(data);

    }

    public void process15(Integer id, String address) {
        Entity15 data = entity15Repository.findById(id).get();
        data.setAddress(address);
        entity15Repository.save(data);
    }


    public void process16(Integer id) {
        entity14Repository.deleteById(id);
    }

    public void process17(Integer id) {
        entity15Repository.deleteById(id);
    }
}
