package com.example.spring.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_table26")
public class Entity26 {
    @EmbeddedId
    private Entity26Id id;

    private String job;
    private Integer age;
    private String address;

}
