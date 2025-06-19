package com.example.spring.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.spring.entity.Entity35}
 */
@Value // 있어도 그만 없어도 그만
// AllArgsConstructor, Getter 만 있다. 읽기 전용으로 쓰인다.
// 필요하면 추가 어노테이션을 작성하면 된다.
@Data
public class Entity35Dto implements Serializable {
    Integer id;
    String lectureTitle;
    String info;
    String place;
}