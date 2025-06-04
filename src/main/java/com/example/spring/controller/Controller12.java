package com.example.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main12")
public class Controller12 {
    @GetMapping("sub1")
    public String sub1(Model model) {
        model.addAttribute("address", "seoul");

        // view로 forward
        return "main12/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model,
                       // redirect 시나리오에서 model에 값을 전달해주는 역할
                       RedirectAttributes rttr) {

        System.out.println("Controller12.sub2");

        model.addAttribute("country", "korea");
        rttr.addFlashAttribute("city", "seoul");

        // redirection: 다른 곳으로 요청하라는 응답.
        // 왜 다른 곳이지?
        // sub2로 요청을보낸다.
        // url을 sub2로 입력했지만, sub3으로 바뀐다.
        return "redirect:/main12/sub3";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {

        System.out.println("Controller12.sub3");

        model.addAttribute("email", "yahoo");

        return "main12/sub3";
    }

    // 연습
    // get/ main12/ sub4로 요청오면
    // : /main12/sub5로 redirection 시키고

    // get/main12/sub5에서
    // : main12/sub5.html로 forward

    // view에서 name Model attribute

    @GetMapping("sub4")
    public String sub4(Model model, RedirectAttributes rttr) {
        rttr.addFlashAttribute("name", "donald");

        return "redirect:/main12/sub5";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {

        return "main12/sub5";
    }

    @GetMapping("sub6")
    public String sub6(RedirectAttributes rttr) {

        // 다음 요청 Model에 옮겨 닮는다.
        // 휘발성으로 잠시 사용하고 사라진다.
        rttr.addFlashAttribute("nickName", "trump");

        //qeury String에 붙음
        // ?address=jeju
        rttr.addAttribute("address", "jeju");

        return "redirect:/main12/sub7";
    }

    @GetMapping("sub7")
    public String sub7(Model model) {

        return "main12/sub7";
    }

    // 연습
    // get /main12/sub8 요청오면
    // : model(RedirectAttribute) 에 item:car
    // 쿼리스트링에 company: tesla를 붙이기

    // get/main12/sub9로 리디렉션하고
    // : main12/sub9 view로 포워드하고
    // item(model attribute)
    // company(request param)을 출력

    @GetMapping("sub8")
    public String sub8(Model model, RedirectAttributes rttr) {

        rttr.addFlashAttribute("item", "car");
        rttr.addAttribute("company", "tesla");
        return "redirect:/main12/sub9";
    }

    @GetMapping("sub9")
    public String sub9(Model model) {


        return "main12/sub9";
    }

    // main
    @GetMapping("sub10")
    public String sub10(Model model) {

        return "main12/sub10";
    }

    // login page
    @GetMapping("sub11")
    public String sub11(Model model) {

        return "main12/sub11";
    }

    // login 처리
    @PostMapping("sub11")
    public String sub11Process(String id, RedirectAttributes rttr, HttpSession session) {

        System.out.println(id + "로그인 처리");

        session.setAttribute("userId", id);
        rttr.addFlashAttribute("message", id + "님이 로그인 되었습니다.");

        return "redirect:/main12/sub10";
    }

    // logout
    @RequestMapping("sub11/logout")
    public String sub11Logout(HttpSession session, RedirectAttributes rttr) {
        // session attribute만 지우기
        // session.removeAttribute("userId");

        // session 객체 지우기
        session.invalidate();

        rttr.addFlashAttribute("message", "로그아웃 되었습니다.");

        return "redirect:/main12/sub10";
    }


    // 연습: 로그인 예제
    // 메소드 3개
    // main, login, login 처리
    // html 2개
    // main, login 페이지

    //main
    @GetMapping("sub12")
    public String sub12(Model model) {

        return "main12/sub12";
    }

    // login page
    @GetMapping("sub13")
    public String sub13(Model model) {

        return "main12/sub13";
    }

    // login 처리
    @PostMapping("sub13")
    public String sub13Process(String id, RedirectAttributes rttr, HttpSession session) {

        System.out.println(id + "로그인 처리");
        session.setAttribute("userId", id);
        rttr.addFlashAttribute("message", id + "로그인 되었습니다.");

        return "redirect:/main12/sub12";
    }

    @RequestMapping("sub13/logout")
    public String sub13Logout(HttpSession session, RedirectAttributes rttr) {
        // session attribute만 지우기
        // session.removeAttribute("userId");

        // session 객체 지우기
        session.invalidate();

        rttr.addFlashAttribute("message", "로그아웃 되었습니다.");

        return "redirect:/main12/sub12";
    }
}
