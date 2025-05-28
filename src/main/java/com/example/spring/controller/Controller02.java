package com.example.spring.controller;


import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Controller
public class Controller02 {

    // Query /main2/sub1?name&address
    // ? 뒤에 있는것을 queryString이라고한다.
    // name은 파라미터
    // query string : name1 = value1&name2
    // request parameter = & 사이사이에 있는 모든 것.
    // 파라미터를 받아서 분석하고 값을 내놓는다.
    @RequestMapping(value = "/main2/sub1", params = {"name", "address"})
    public void sub1(WebRequest request) {
        // 헤더 정보
        request.getHeader("User-Agent");
        System.out.println("Controller02.sub1");
    }

    // /main2/sub2?name&address
    // ? : query string
    // query string : name1=value1&name2=value2
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {
        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name=musk
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address=seoul
    // /main2/sub3?address=jeju
    @RequestMapping(value = "/main2/sub3", params = "address")
    public void sub4(WebRequest request) {
        // address request parameter를 얻어서 출력하는 코드
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub4");
    }

    // @RequestParam : 해당 이름의 request parameter를 method parameter에 binding 해줌

    // /main2/sub5?email=gmail
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String str) {
        System.out.println("str = " + str);
    }

    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
// 이때 리퀘스트 파라미터를 쓰면 위 파라미터 생략 가능
    public void sub6(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    @RequestMapping("/main2/sub7") // 파라미터 생략 가능, value도~
    public void sub7(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // 연습:
    // /main2/sub8?address=jeju&country=korea&city=gangnam
    @RequestMapping("/main2/sub8")
    public void sub8(@RequestParam("address") String address,
                     @RequestParam("country") String country,
                     @RequestParam("city") String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    @RequestMapping("/main2/sub9")
    public void method9(
            @RequestParam("city") String city,
            @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);
    }

    @RequestMapping("/main2/sub010")
    public void method10(
            @RequestParam("city") String city,
            @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter의 이름이 method parameter와 같으면
    // @requestParam의 value 속성을 생략해도됨
    // /main2/sub11?city=seoul&age=44
    @RequestMapping("/main2/sub11")
    public void method11(
            @RequestParam("city") String city,
            @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }


    // request parameter의 이름이 method parameter와 같으면
    // @requestParam의 value 속성을 생략해도됨
    // @RequestParam을 생략해도됨
    // http://localhost:8080/main2/sub12?city=seoul&age=44
    @RequestMapping("/main2/sub12")
    public void method12(String city, int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // 연습: 아래 URL로 요청 올 때 적절히 처리하는 메소드 작성
    // main2/sub13?email=gmail&score=88.8&married=true
    // main2/sub14?&score=88.8&married=true
    // @RequestParam이 없으면 생략될수도 있다.
    @RequestMapping("/main2/sub13")
    public void method13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("marreid = " + married);
    }

    //RequestParam을 붙였든 안붙였든 동일하게 동작한다.
    // main2/sub14?email=gmail&score=88.8&married=true

    // @RequestParam을 붙이면, 꼭 있어야한다.
    // 왜냐하면 RequesParam의 requide 값이 true이기 때문. (false로 바꾸면 가능하다)
    @RequestMapping("/main2/sub14")
    public void method14(@RequestParam(required = false) String email,
                         @RequestParam(required = false) Double score, // 래퍼 타입을 쓰면 null 값으로 반송.
                         Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    @RequestMapping("/main2/sub15")
    public void method15(@RequestParam(required = false, defaultValue = "") String email,
                         @RequestParam(required = false, defaultValue = "") Double score,
                         @RequestParam(required = false, defaultValue = "") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    @RequestMapping("/main2/sub16")
    public void method16(@RequestParam(required = false, defaultValue = "") String email,
                         @RequestParam(required = false, defaultValue = "0.0") Double score,
                         @RequestParam(required = false, defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 연습:
    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?city=seoul&home=jeju
    // /main2/sub17?city=seoul&age=33
    // /main2/sub17?home=jeju&age=33

    // city 기본값 ""
    // home 기본값 ""
    // age 기본값 ""

    @RequestMapping("/main2/sub17")
    public void method17(@RequestParam(defaultValue = "") String city,
                         @RequestParam(defaultValue = "") String home,
                         @RequestParam(defaultValue = "0") Integer age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }

    // 하나의 request parameter(요청 파라미터, 요청변수)가 여러 값일때
    //  /main2/sub18?city=seoul&city=jeju&city=busan
    //  /main2/sub18?city=seoul&city=jeju
    //  /main2/sub18?city=seoul
    //  /main2/sub18?

    @RequestMapping("/main2/sub18")
    public void method18(String[] city) {
        System.out.println("Arrays.toString(city) = " + Arrays.toString(city));
    }

    @RequestMapping("/main2/sub19")
    // ArrayList로 받을때는 ("city 써주기)
    public void method19(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println("city = " + city);
    }

    // 연습: 아래 URL로 요청 올 때 일하는메소드 완성
    // main2/sub20?country=korean&core=90&score80&score=70
    @RequestMapping("/main2/sub20")
    public void method20(@RequestParam(value = "country", defaultValue = "") String country,
                         @RequestParam(value = "core", defaultValue = "") Integer[] score) {
        System.out.println("country = " + country);
        System.out.println("country = " + Arrays.toString(score));
    }


    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=99&married=true
    @RequestMapping("/main2/sub21")
    public void method21(String city,
                         String email,
                         String address,
                         Integer age,
                         Double socre,
                         Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("socre = " + socre);
        System.out.println("married = " + married);
    }

    // /main2/sub22?city=서울&email=gmail&address=신촌&age=88&score=99&married=true
    // 를 한번에 받는 방법
    @RequestMapping("/main2/sub22")
    public void method22(@RequestParam Map<String, Objects> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=99&score=87&married=true
    // 를 한번에 받으면서 같은 값을 또 받는 방법
    // MultiValueMap 을 사용.  List로 만들어진다.
    @RequestMapping("/main2/sub23")
    public void method23(@RequestParam MultiValueMap<String, Objects> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @RequestMapping("/main2/sub24")
    public void method24(WebRequest request) {
        Class<? extends WebRequest> a = request.getClass();
        if (request instanceof StandardServletAsyncWebRequest b) {
            Object c = b.getNativeRequest();
            System.out.println("c.getClass() = " + c.getClass());
            if (c instanceof RequestFacade d) {
                String method = d.getMethod();
                String servletPath = d.getServletPath();
                System.out.println("method = " + method);
                System.out.println("servletPath = " + servletPath);
            }

        }
        System.out.println("a = " + a);
    }
}
