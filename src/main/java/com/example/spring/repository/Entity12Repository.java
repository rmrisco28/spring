package com.example.spring.repository;

import com.example.spring.entity.Entity12;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity12Repository extends JpaRepository<Entity12, Integer> {
}