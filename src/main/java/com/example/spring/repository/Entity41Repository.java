package com.example.spring.repository;

import com.example.spring.dto.OrderInfo;
import com.example.spring.entity.Entity41;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity41Repository extends JpaRepository<Entity41, Integer> {
    @Query(value = """
            SELECT o.order_date, p.name product_name, p.price, o.quantity, c.name category_name
            FROM my_table39 p
                     JOIN my_table40 c
                          ON p.category_id = c.id
                     JOIN my_table41 o
                          ON o.product_id = p.id;
            """, nativeQuery = true)
    List<OrderInfo> query1();
}


/*    @Query(value = """
            SELECT p.id, p.name product_name, p.price, c.name category_name
            FROM my_table39 p JOIN my_table40 c
                                ON p.category_id = c.id
            """, nativeQuery = true)
            */