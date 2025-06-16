package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table8")
public class Entity8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private Double salary;
    private LocalDateTime inserttedAt;
    private LocalDate hireDate;
}

/*
CREATE TABLE my_table8
( id INT AUTO INCREMENT PRIMARY KEY,
address VARCHAR(23),
salary DECIMAL(10,2),



*/
