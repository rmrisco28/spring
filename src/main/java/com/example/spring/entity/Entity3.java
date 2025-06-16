package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table3")
@Getter
@Setter
@ToString
public class Entity3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @Column(name = "email")
    // 클래스의 field 명과 table 의 컬럼영이 같으면 @Column 생략 가능
    private String email;
    //    @Column(name = "info")
    private String info;
    //    @Column(name = "nick")
    private String nick;

    private String country;
    // java 변수명 관습 lowerCamelCase
    // 변수명과 테이블 컬럼명의 작성 관습이 다르기 때문에
    // @Column을 써줘야함. 은 사실 안써도 된다
    // 관습을 잘 고쳤다.
    // 관습에 맞게 잘써야 가능하다.
//    @Column(name = "home_address")
    private String homeAddress;

    // 연습
    // work_address 테이블 컬럼에 매핑되는
    // java field 작성하기
    private String workAddress;

}
