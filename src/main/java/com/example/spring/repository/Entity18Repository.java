package com.example.spring.repository;

import com.example.spring.entity.Entity18;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface Entity18Repository extends JpaRepository<Entity18, Integer> {
    // findById
    // save
    // deleteById

    // sql
    // jpql

    // 지금부터는
    // 메소드 이름으로 쿼리 만들기

    // SELECT * FROM supplier WHERE country = :country
    List<Entity18> findByCountry(String country);

    // SELECT * FROM supplier WHERE city = :city
    List<Entity18> findByCity(String city);


    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword
    // keyword에 %(wildcard) 붙여서 호출
    List<Entity18> findBySupplierNameLike(String keyword);

    // 이렇게 적을 수도 있지만 간단하게 아래처럼 적을 수도 있다.
    List<Entity18> findBySupplierNameContains(String supplierName);

    // SELECT * FROM supplier WHERE country in (?, ?, ?)
    List<Entity18> findByCountryIn(List<String> country);

    // 연습
    // SELECT * FROM supplier WHERE country IN(?,?,?) ORDER By supplier_name
    List<Entity18> findByCountryInOrderBySupplierName(List<String> country);

    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword ORDER BY supplier_nameDESC
    List<Entity18> findBySupplierNameContainsOrderBySupplierNameDesc(String keyword);

    void deleteByCountry(String country);

    @Modifying
    @Query("""
            DELETE FROM Entity18 e
            WHERE e.country = :country
            """)
    void deleteCountry(String country);
}