package com.example.spring.repository;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface Entity19Repository extends JpaRepository<Entity19, Integer> {
    // findByID

    // 쿼리를 보고 메소드 완성시키기
    // 연습
    // SELECT * FROM product WHERE category_id = :categoryID
    List<Entity19> findByCategoryId(Integer id);

    // SELECT * FROM product WHERE supplier_id = :supplierID
    List<Entity19> findBySupplierId(Integer id);

    // SELECT * FROM product WHERE price BETWEEN :p1 AND :p2
    List<Entity19> findByPriceBetween(Double lower, Double higher);

    // 같은 내용인데,
    // SELECT * FROm product WHERE price >= :p1 AND price <=:p2
    List<Entity19> findByPriceGreaterThanEqualAndPriceLessThanEqual(Double lower, Double higher);

    // SELECT * FROM product WHERE price >= :price
    List<Entity19> findByPriceGreaterThanEqual(Double p1);

    // SELECT * FROM product WHERE category_id IN (?, ?, ?)
    List<Entity19> findByCategoryIdIn(List<Integer> categoryIds);

    // SELECT * FROm product WHERE product_name LIKE :keyword
    // with wildcard (기호 필요) -> %keyword%
    List<Entity19> findByProductNameLike(String keyword);

    // without wildcard (기호 필요x) -> keyword
    List<Entity19> findByProductNameContains(String keyword);

    /* SQL은 배운대로 쓰면 됨. 쉬움
    SELECT *
    FROM product
    WHERE category_id = :id
    ORDER BY price DESC
    */
    @Query(value = """
            SELECT *
            FROM product
            WHERE category_id = :id
            ORDER BY price DESC
            """, nativeQuery = true)
    List<Entity19> query1(Integer id);

    @Query("""
            SELECt p
            FROM Entity19 p
            WHERE p.categoryId = :id
            ORDER BY p.price DESC
            """)
    List<Entity19> query2(Integer id);

    List<Entity19> findByCategoryIdOrderByPrice(Integer categoryId);
                    
    List<Entity19> findByCategoryIdOrderByPriceAsc(Integer id);

    List<Entity19> findByCategoryIdOrderByPriceDesc(Integer categoryId);

}