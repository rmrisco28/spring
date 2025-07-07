package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import com.example.spring.dto.MyBean292;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main29")
@ResponseBody
public class controller29 {

    @PostMapping("sub1")
    public String sub1() {
        System.out.println("controller29.sub1");
        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("controller29.sub2");
        return null;
    }

    // 연습: react에서 3번째 버튼 만들고 클릭해서 아래 메소드가 일하도록
    @PostMapping("sub3")
    public String sub3() {
        System.out.println("controller29.sub3");
        return null;
    }

    @PostMapping("sub4")
    public String sub4(@RequestBody Map<String, Object> map) {
        // @RequestBody: JSON을 해당 타입(Map)으로 역직렬화(디코딩, 파싱) 해주는 어노테이션
        System.out.println("controller29.sub4");
        System.out.println("map = " + map);
        return null;
    }

    @PostMapping("sub5")
    public String sub5(@RequestBody Map<String, Object> map) {
        System.out.println("controller29.sub5");
        System.out.println("map = " + map); // {address= seoul, score=88.12, country=korea}
        return null;
    }

    @PostMapping("sub6")
    public String sub6(@RequestBody Map<String, Object> map) {
        Object val1 = map.get("val1"); // "신촌" String
        Object val2 = map.get("val2"); //  55 number
        Object val3 = map.get("val3"); // 77.12 number
        Object val4 = map.get("val4"); // true boolean
        Object val5 = map.get("val5"); // null

        System.out.println("val1.getClass().getSimpleName() = " + val1.getClass().getSimpleName()); // String
        System.out.println("val2.getClass().getSimpleName() = " + val2.getClass().getSimpleName()); // Integer
        System.out.println("val3.getClass().getSimpleName() = " + val3.getClass().getSimpleName()); // Double
        System.out.println("val4.getClass().getSimpleName() = " + val4.getClass().getSimpleName()); // Boolean
        System.out.println("val5= " + val5);// null
        return null;
    }

    @PostMapping("sub7")
    public String sub7(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object score = map.get("score");
        Object age = map.get("age");
        Object married = map.get("married");

        System.out.println(address.getClass().getSimpleName()); //
        System.out.println(score.getClass().getSimpleName());
        System.out.println(age.getClass().getSimpleName());
        System.out.println(married.getClass().getSimpleName());

        System.out.println(map);

        return null;
    }

    @PostMapping("sub8")
    public String sub8(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object age = map.get("age");
        Object fruits = map.get("fruits");

        // JSON의 array 타입은 JAVA의 ArrayList로 파싱된다.
        System.out.println(fruits.getClass().getSimpleName()); // ArrayList
        System.out.println("fruits = " + fruits);

        return null;
    }

    @PostMapping("sub9")
    public String sub9(@RequestBody Map<String, Object> map) {
        Object name = map.get("name");
        Object teams = map.get("teams"); //ArrayList
        Object person = map.get("person"); // object -> Map 으로 parsing

        System.out.println(person.getClass().getSimpleName()); // Map
        System.out.println(person);

        return null;
    }

    // 연습 : react 에서 10번째 버튼과 메소드 작성해보기
    @PostMapping("sub10")
    public String sub10(@RequestBody Map<String, Object> map) {
        Object cityList = map.get("cityList");
        Object team = map.get("team");

        System.out.println(cityList.getClass().getSimpleName()); // ArrayList
        System.out.println(team.getClass().getSimpleName()); // ...Map

        System.out.println(cityList);
        System.out.println(team);

        return null;
    }

    @PostMapping("sub11")
    public String sub11(@RequestBody List<Object> data) {
        System.out.println(data);
        System.out.println(data.getClass().getSimpleName());

        return null;
    }

    @PostMapping("sub12")
    public String sub12(@RequestBody List<Map<String, Object>> data) {
        for (Map<String, Object> map : data) {
            System.out.println(map);
        }
        return null;
    }

    @PostMapping("sub13")
    public String sub13(@RequestBody MyBean291 dto) {
        System.out.println(dto.getNickName());
        System.out.println(dto.getAge());
        System.out.println(dto.getMarried());
        System.out.println(dto.getAddress());
        System.out.println(dto.getTeam());
        return null;
    }

    @PostMapping("sub14")
    public String sub14(@RequestBody MyBean292 dto) {
        System.out.println(dto.getCity());
        System.out.println(dto.getScore());
        System.out.println(dto.getChecked());
        System.out.println(dto.getPerson());
        System.out.println(dto.getFruits());
        return null;
    }
}
