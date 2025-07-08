package com.example.spring.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MyBean322 {
    private Integer id;
    private String title;
    private Double price;
    private Map<String, Object> category;
    private List<String> order;
}
