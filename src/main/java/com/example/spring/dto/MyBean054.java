package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyBean054 {
    private String name;
    private Integer age;
    private List<String> phones;
}
