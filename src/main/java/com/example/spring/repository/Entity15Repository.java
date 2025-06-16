package com.example.spring.repository;

import com.example.spring.entity.Entity15;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 써도되고 안써도 되고
public interface Entity15Repository extends JpaRepository<Entity15, Integer> {
}