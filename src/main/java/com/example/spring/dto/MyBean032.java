package com.example.spring.dto;

public class MyBean032 {
    private String name;
    private String company;
    private String home;
    private Integer age; // 기본타입(int)일 경우 기본 값 0이 들어가기 때문에 헷갈릴 수 있음
    // 이게 값을 0으로 준건지, 아닌지 알수 없기 때문에, 래퍼타입 Integer로 타입 설정

    @Override
    public String toString() {
        return "MyBean032{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", home='" + home + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


    // 기본생성자 생략
    public MyBean032() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
