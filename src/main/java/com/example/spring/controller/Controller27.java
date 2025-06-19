package com.example.spring.controller;

import com.example.spring.service.Service9;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("main27")
public class Controller27 {
    private final Service9 service9;

    @GetMapping("sub1")
    public String main27() {

        return "main27/sub1";
    }

    @PostMapping("sub1")
    public String sub1(String username, MultipartFile upload) {
        service9.action1(username, upload);
        return "redirect:/main27/sub1";
    }

//    @GetMapping("sub1")
//    public String sub2() {
//        return "main27/sub1";
//    }

    @PostMapping("sub2")
    public String sub3(String address,
                       @RequestParam(name = "uploadFile")
                       // 이름을 다르게 할꺼면 어노테이션 작성 필수
                       MultipartFile upload) {
        service9.action2(address, upload);
        return "redirect:/main27/sub1";
    }

    @PostMapping("sub3")
    public String post3(MultipartFile[] upload) {
        service9.action3(upload);
        return "redirect:/main27/sub1";
    }
}
