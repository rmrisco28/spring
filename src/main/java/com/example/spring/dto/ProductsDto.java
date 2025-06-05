package com.example.spring.dto;

import lombok.Data;

@Data
public class ProductsDto {

    private Integer Id;
    private String Name;
    private Integer supplier;
    private Integer category;
    private String unit;
    private Double price;
}
