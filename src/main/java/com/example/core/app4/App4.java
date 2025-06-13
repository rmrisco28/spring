package com.example.core.app4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App4 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App4.class, args);
        Controller1 b1 = context.getBean(Controller1.class);
        Service1 b2 = context.getBean(Service1.class);
        b1.method1();
        b2.action1();

        // 객체도 스프링이 만들어주는데,
        // 주입도 스프링이 해줘야하는것아니냐?
        // 아까 세가지 방법처럼 세가지가 있음
        b1.method2(); // NullPointerException
    }

}


@Component
class Controller1 {
    @Autowired // field 기반 dependency injection 첫번째 주입 방법
    Service1 service1;

    public void method2() {
        System.out.println("서비스 메소드 실행");
        service1.action1();
    }

    public void method1() {
        System.out.println("Controller1.method1");
    }
}

@Component
class Service1 {
    public void action1() {
        System.out.println("Service1.method1");
    }
}