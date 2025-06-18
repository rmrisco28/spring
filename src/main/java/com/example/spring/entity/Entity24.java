package com.example.spring.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "my_table24")
@Getter
@Setter
public class Entity24 {
    @EmbeddedId
    private Entity24Id id;

    private String email;
    private String password;
    private Integer score;

}
