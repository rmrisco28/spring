package com.example.spring.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "my_table9")
public class Entity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Date birthday;
}
/*CREATE TABLE my_table9
(
    id       INT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)       NULL,
    address  VARCHAR(255)       NULL,
    birthday date               NULL,
    CONSTRAINT pk_my_table9 PRIMARY KEY (id)
);*/