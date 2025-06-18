package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table28")
@Getter
@Setter
@ToString
public class Entity28 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private Integer price;
    private String unit;

    // category_id
//    private Integer categoryId; 라고 쓰면 안되고,
    // 이제 중요. 테이블 기준으로 , 28번테이블의 categoryID가 27번테이블의 id를 가리키고 있다.
    // 테이블간의 관계에서는 primary key컬럼을주면 되는데
    // 자바 객체 끼리의 관계는 Entity28이 Entity27객체를 안에 갖고있으면 된다.
    // 그리고 @JoinColumn 으로 받는 컬럼명을 적어줘야한다.
    // 관계를 보면 27이 1, 28이 n인데 1대 n이고
    // 현재 테이블(table28)이 n 상태이기 때문에
    // Many to One 을 써야한다.
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Entity27 category;
    // 어떤 컬럼을 foreign key로 쓰는지 명시하고,
    // 다대1 상태인것을 표기해줘야한다.
}
