package com.example.core.app9;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App9 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App9.class, args);
        Comp2 bean = context.getBean(Comp2.class);
        // 문제 없이 실행되게 Comp2에 생성자 만들고
        // annotation들 적용하기
        bean.action1();
    }

}
