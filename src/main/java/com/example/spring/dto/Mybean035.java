package com.example.spring.dto;

// Getter, Setter, to String, equalsAndHashCode, RequiredArgsConstructor
// 다섯개는 잘 사용하기 때문에 한번에 만드는 어노테이션이 있음

import lombok.Data;

@Data
public class Mybean035 {
    private String address;
    private Double salary;
}
