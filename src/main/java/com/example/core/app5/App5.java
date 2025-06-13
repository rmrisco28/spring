package com.example.core.app5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App5 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App5.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        bean.go(); // 문제 없이 실행되도록 annotation 들 완성하기

    }
}
