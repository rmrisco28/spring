package com.core.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
// main 메소드가 있는 퍀키지와 그 하위 패키지를
// 모두 scan 해서 특정 어노테이션(Component)이
// 붙은 클래스의 객체를 생성해서 보관
public class App2 {
    public static void main(String[] args) {
        // 메인메소드에서
        /*
        // 서비스 객체 만들고
        // 컨트롤러 객체 만들고
        // 서비스를 컨트롤러 객체에 주입(injection)했다.
        */
        // 우리가 직접 코드를 짰었는데,  위 세가지를 spring에게 제어를 넘길 수 있다.

        // 1. 객체 만드는 얘기먼저
        var context = SpringApplication.run(App2.class, args);
        // 메소드가 있는지 꺼내보는 메소드
        // getBean(): 스프링이 만든 개체얻기(Spring bean) 얻기
        Controller1 bean = context.getBean(Controller1.class);
        bean.method1();
        Object c1 = context.getBean("c1");

        System.out.println(bean == c1);
    }
}

@Component("c1")
class Controller1 {
    public void method1() {
        System.out.println("요청 처리 메소드");
    }
}