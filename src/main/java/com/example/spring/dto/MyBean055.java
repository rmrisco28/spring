package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyBean055 {
    private Integer number;
    private List<String> address;
    private List<String> company;
}
