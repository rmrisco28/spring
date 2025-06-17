package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service4 {
    private final Entity16Repository entity16Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        System.out.println("111111111111111111111111111111");
        Page<Entity16> list = entity16Repository.findAll(PageRequest.of(1 - 1, 10));
        List<Entity16> data = list.getContent();
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
        System.out.println("2222222222222222222222222222222");
        List<Entity16> data2 = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : data2) {
            System.out.println(entity16);
        }
    }

    public void action2() {
        System.out.println("############# 1page ###############");
        List<Entity16> list1 = entity16Repository.findAll(PageRequest.of(1 - 1, 7)).getContent();
        for (Entity16 entity16 : list1) {
            System.out.println(entity16);
        }
        System.out.println("############# 2page ###############");
        List<Entity16> data2 = entity16Repository.findAll(PageRequest.of(2 - 1, 7)).getContent();
        for (Entity16 entity16 : data2) {
            System.out.println(entity16);
        }
    }

    public void action3() {
        // 페이징 and 정렬
        System.out.println("############# 1page ###############");
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of(1 - 1, 7, Sort.by("productName")))
                .getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }
    }

    public void action4() {
        // 계약명 기준 역순으로 1페이지 출력하기 (1페이지 데이터 10개)
        System.out.println("############# 1page ###############");
        List<Entity16> list1 = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("ContactName").descending()))
                .getContent();
        for (Entity16 entity16 : list1) {
            System.out.println(entity16);
        }
    }

    public void action5() {
        // 가격 역순으로 10개씩 1페이지 상품 내용 보기
        System.out.println("############# 1page ###############");
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("price")
                        .descending())).getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }
    }

    public void action6(Integer page) {
        System.out.println("############# " + page + " ###############");
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = page1.getContent();
        int totalPages = page1.getTotalPages();// 전체 페이지 수
        long totalElements = page1.getTotalElements();// 전체 데이터 수

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        for (Entity16 entity16 : content) {
            System.out.println(entity16);
        }
    }

    public void action7(Integer page) {
        System.out.println("############# " + page + " ###############");
        Page<Entity19> page1 = entity19Repository.findAll(PageRequest.of(page - 1, 10, Sort.by("price")));
        List<Entity19> content = page1.getContent();
        boolean nextPage = page1.hasNext();// 다음 페이지 있다면 true
        boolean previousPage = page1.hasPrevious();// 이전 페이지가 있다면 true
        int totalPages = page1.getTotalPages(); // 전체 페이지 수
        long totalElements = page1.getTotalElements(); // 전체 데이터 수
        System.out.println("previousPage(이전페이지 여부) = " + previousPage);
        System.out.println("nextPage(다음페이지 여부) = " + nextPage);
        System.out.println("totalPages(전체페이지 개수) = " + totalPages);
        System.out.println("totalElements(전체 데이터 개수) = " + totalElements);
        content.forEach(entity19 -> System.out.println(entity19));

    }
    
}
