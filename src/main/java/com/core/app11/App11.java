package com.core.app11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App11 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App11.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        // 잘 되도록 코드 작성(lombok의 어노테이션 활용)

        bean.some();
    }
}
