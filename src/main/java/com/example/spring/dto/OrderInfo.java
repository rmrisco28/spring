package com.example.spring.dto;

import java.time.LocalDate;

public interface OrderInfo {
    Integer getId();

    LocalDate getOrderDate();

    String getProductName();

    Integer getPrice();

    Integer getQuantity();

    String getCategoryName();

}
