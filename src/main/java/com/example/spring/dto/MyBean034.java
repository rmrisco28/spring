package com.example.spring.dto;

import lombok.*;

@Getter // getter no usages
@Setter // setter
@ToString // toString
@EqualsAndHashCode // equals, hashcode
//@NoArgsConstructor // 파라미터 없는 생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
@RequiredArgsConstructor // final 필드를 초기화하는 생성자
public class MyBean034 {
    private String home;
    private final Integer age;
    // final 필드는 값을 꼭 한번 받아야함.
    // 근데 파라미터 없는 생성자가 에러가 남. (주석처리)
}
