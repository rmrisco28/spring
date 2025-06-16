package com.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bean1 {

    final Bean2 bean2;

    public void some() {
        bean2.crud();
    }
}