package com.example.core.app1;

public class App1 {
    public static void main(String[] args) {
        // 업무 로직 실행
        Service1 service = new Service1();

        //생성자를 통해서 Dependency Injection (방법2)
        Controller1 controller1 = new Controller1(service);

        // setter 를 통해서 Dependency Injection (방법3)
        controller1.setService(service);

        controller1.method1();
    }
}


class Controller1 {
    // 모든 메소드에 편하게 작동 할수 있게 여기에 작성도 가능
    // 이 필드(컨트롤러)를 의존한다고 표현할 수 있음.
    // dependency(의존성, 의존객체)
    // field 통해서 직접 Dependency Injection(DI) 주사 했다. (방법1)
    // Service1 service1 = new Service1(); 이렇게 넣을 수도 있고.


    Service1 service;

    // 생성자를 이용해서 넣거나,
    public Controller1(Service1 service) {
        this.service = service;
    }

    // setter를 이용해서 넣거나 했었음.
    public void setService(Service1 service) {
        this.service = service;
    }

    public void method1() {
        // 요청받고
        // CRUD
        service.create();
        // 모델에 값 넣고
        // view에 forward
    }

    public void method2() {
        // 요청받고
        service.read();
        // 모델에 넣고
    }
}

class Service1 {
    public void create() {
        // 새 데이터 입력 코드
    }

    public void read() {
        // 기존 데이터 조회 코드
    }
}

