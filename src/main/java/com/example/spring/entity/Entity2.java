package com.example.spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table2")
@Getter
@Setter
@ToString
public class Entity2 {
    // 별일 없으면 테이블의 네개 컬럼을 만들고
    // 데이터 타입을 매칭 시켜준다.
    @Id // pk 역할
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "city")
    String city;
}
