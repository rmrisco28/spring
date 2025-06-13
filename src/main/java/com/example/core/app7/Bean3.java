package com.example.core.app7;

import org.springframework.stereotype.Component;

@Component // spring Bean으로 만드는 어노테이션
public class Bean3 {
    public void abc() {
        System.out.println("Bean3.abc");
    }
}
