package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "my_table7", schema = "jpa")
public class Entity7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address", length = 30)
    private String address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}