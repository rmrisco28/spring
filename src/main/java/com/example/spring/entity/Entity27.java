package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table27")
@Getter
@Setter
@ToString
public class Entity27 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name = "category_name") 정석대로 썼기 때문에 생략 가능
    private String category_name;
    private String info;

}
