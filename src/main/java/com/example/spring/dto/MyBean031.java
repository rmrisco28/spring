package com.example.spring.dto;

public class MyBean031 {
    // private field
    private String name;
    private String address;

    // parameter 없는 생성자 (기본 생성자)
    // 안만들어도 큰 상관없음.
//    public MyBean031() {
//    }

    //getter/setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
