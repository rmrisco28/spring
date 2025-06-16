package com.example.spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "my_table4")
@ToString
@Getter
@Setter
public class Entity4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // INT
    private String name;// VARCHAR
    private Double score; // DEC(10,2)
    private LocalDate birthDate; // DATE
    private LocalTime startAt; // TIME
    private LocalDateTime createdAt; // DATETIME
}
