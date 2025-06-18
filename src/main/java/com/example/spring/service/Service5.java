package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity20;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity20Repository;
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {
    private final Entity16Repository entity16Repository;
    private final Entity20Repository entity20Repository;
    private final Entity18Repository entity18Repository;

    public void action1(Integer page) {
        // repository 사용
        Page<Entity16> pageContent = entity16Repository.findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);
    }
    // 내가 만든 페이지와 정렬을 동시에 어떻게 할 수 있는가?
    // 같은 메소드 오버로딩 할 수 있는데, findAll(Pageable)
    // 마지막 pageable을 받으면 됨.

    public void action2(String country) {
        List<Entity16> list = entity16Repository.findByCountry(country);
        list.forEach(System.out::println);
    }

    public void action3(String country, Integer page) {
        Page<Entity16> pageContent = entity16Repository
                .findByCountry(country,
                        PageRequest.of(page - 1, 10,
                                Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);
    }

    public void action4(String keyword, Integer page) {
        // SELECT * FROM customer
        // WHERE customer_name LIKE '%ed%'
        // OR contact_name LIKE '%ed%'
        List<Entity16> list = entity16Repository
                .findByCustomerNameContainingOrContactNameContaining(keyword,
                        keyword,
                        PageRequest.of(page - 1, 10, Sort.by("id").descending()))
                .getContent();

        list.forEach(System.out::println);
    }

    public void action5(Integer id) {
        entity16Repository.deleteById(id); // jpa Repository 상속 받아서 되는 것.
        // 지울 수 있지만 post 방식으로 받아야 한다.
    }

    @Transactional
    public void action6(String country) {
        entity16Repository.deleteBycountry(country);
    }

    public void action7() {
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }
        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional
    public void action8() {
        // 보통 service의 하나의 메소드가 하나의 transaction 이다.
        // -> @Transactional 어노테이션을 sersvice 의 모든 메소드에 붙여야 한다.
        // 그래야 한 메소드가 하나의 업무로 처리가 된다.
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }
        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }


    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);
    }

    @Transactional
    public void action10(String country) {
        // select 후 하나씩 지움: 성능 이슈 있음.
        // entity16Repository.deleteBycountry(country);

        // -> jpql이나 sql로 직접 작성해서 지워야함
        entity16Repository.bulkDeleteByCountry(country);
    }

    @Transactional
    public void action11(String country) {
        entity18Repository.deleteCountry(country);
    }

    @Transactional
    public void action12(String country) {
        // update, delete, insert 했다고 침고

        // rollback 된다.
        // throw new RuntimeException();
        if (true) {

            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 익셉션이 발생하면 runtimeException 으로 바꿔서 처리 할 것.
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // update,delete, insert
    }

}
