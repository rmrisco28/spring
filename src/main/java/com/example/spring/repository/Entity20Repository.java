package com.example.spring.repository;

import com.example.spring.entity.Entity20;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity20Repository extends JpaRepository<Entity20, String> {
}