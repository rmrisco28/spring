package com.example.core.app13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean // 이 spring bean의 이름은 메소드 이름으로 결정 -> myService
    public Service1 myService() {
        return new Service1();
    }

    @Bean
    public Service2 Bean12345() {
        return new Service2();
    }
}
