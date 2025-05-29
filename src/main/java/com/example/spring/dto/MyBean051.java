package com.example.spring.dto;

import lombok.Data;

@Data
public class MyBean051 {
    private String name;
    private String address;
    private Integer age;

    // information (읽기 전용) propertys
    public String getInformation(){
        return "My name is" + name+ "My address is" + address + "My age is" + age;
    }
}
