package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "my_table6", schema = "jpa")
public class Entity6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "score")
    private Double score;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "started_at")
    private LocalTime startedAt;

    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

}