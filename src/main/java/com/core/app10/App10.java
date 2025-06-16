package com.core.app10;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App10 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App10.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        bean.action();

        Controller2 bean1 = context.getBean(Controller2.class);
        bean1.go();

    }
}
// 그래서 결론은 뭐냐
// @RequiredArgsConstructor  를 쓰려고하는구나.

@Component
@RequiredArgsConstructor
class Controller2 {
    // final을 받는 생성자를 만들어주는 lombok이 있음. @RequiredArgsConstructor

    final Service2 service2;

    // 우리 눈엔 안보이지만, @RequiredArgsConstructor로 생성자가 존재함.

    public void go() {
        service2.action();
    }
}

@Component
class Service2 {
    public void action() {
        System.out.println("Service2.action");
    }
}


@Component
class Controller1 {
    // final은 무조건 값이 한번 들어가는 것.
    // 이땐 꼭 생성자를 만든다.
    final Service1 service1;

    public Controller1(Service1 service1) {
        this.service1 = service1;
    }

    public void action() {
        service1.method1();
    }
}

@Component
class Service1 {
    public void method1() {
        System.out.println("Service1.method1");
    }
}
