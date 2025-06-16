package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table11", schema = "jpa")
public class Entity11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", length = 30)
    private String address;

    @Column(name = "score")
    private Double score;

    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

}