package com.core.app13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller1 {
    final Service1 service1;


    public Service1 getService1() {
        return service1;
    }

    public void get() {
        service1.crud();
    }
}
