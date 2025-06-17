package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 써도 되고 안써도되고
public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    List<Entity16> country(String country);
    // findById
    // save
    // deleteById

    // 직접 만드는 쿼리
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query1(String country);


    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city
            """, nativeQuery = true
    )
    List<Entity16> query2(String city);


    @Query(value = """
            SELECT *
            FROM customer
            WHERE city = :city1 
               OR city = :city2
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            
            SELECT *
            FROM customer
            WHERE customer_name like :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);

    /* SQL: 테이블 대상
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
    */

    // jpql: entity 대상
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.country =:country
            """)
    // e.country는 entity의 속성
    // jpql 은 알리아스를 꼭 써야하고
    List<Entity16> query5(String country);

    // 연습
    // 도시 이름으로 고객 조회하는 쿼리 JPQL로 작성
    // Service, controller 만들기
    /* SQL
       @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city
            """, nativeQuery = true)
    */
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.city = :city
            """)
    List<Entity16> query6(String city);

    /* sql
    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name like :keyword
            """, nativeQuery = true)
    */
    @Query("""
            SELECT c
            FROM Entity16 c
            WHERE c.customerName LIKE :keyword
            """)
    List<Entity16> query7(String keyword);

    /* jpql
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.country =:country
            """)
     */
    List<Entity16> findByCountry(String country);

    List<Entity16> findByCity(String city);
}