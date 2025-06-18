package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table21", schema = "jpa")
@ToString
public class Entity21 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "inserted_at", nullable = false, insertable = false, updatable = false)
    // insertable : 추가할 필요 없을 때
    // updatable : 업데이트 할 필요 없을 때
    private LocalDateTime insertedAt;

}