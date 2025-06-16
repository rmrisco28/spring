package com.example.spring.repository;

import com.example.spring.entity.Entity10;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity10Repository extends CrudRepository<Entity10, Integer> {
    // find 메소드
    // save  메소드
    // delete 메소드를 만들어야 했는데
    // extends CRUD Repository 로 한번에 만들 수 있게 됨
    // entity 명시 후, id의 타입을 명시 하면된다. <Entity10, Integer>

    // 구현된 클래스가 있어야 인터페이스를 구현 할 수 있음.
    // 원래는 이렇게 구현 해야는데, new Entity10Repository
    // 스프링이 인터페이스를 구현한 클래스를 만들어서
    // db 연결 연고 statement,
    // 쿼리 실행하고 result set 처리해서
    // Entity10타입의 객체 리턴.
}
