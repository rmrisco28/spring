package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity25Id implements Serializable {
    private static final long serialVersionUID = 1153482411202188703L;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity25Id entity = (Entity25Id) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.age, entity.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}