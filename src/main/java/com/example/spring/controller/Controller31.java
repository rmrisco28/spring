package com.example.spring.controller;

import com.example.spring.dto.MyBean311;
import com.example.spring.dto.MyBean312;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/main31")
@ResponseBody
public class Controller31 {

    @PostMapping("sub1")
    public String sub1(@RequestParam("name") String name,
                       @RequestParam("age") Integer age,
                       @RequestParam("myFiles[]") MultipartFile[] files) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub2")
    public String sub2(String address,
                       Double score,
                       @RequestParam("yourFiles[]") MultipartFile[] yourFiles) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        if (yourFiles != null && yourFiles.length > 0) {
            for (MultipartFile file : yourFiles) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    // 연습: react에 세번째 버튼 클릭 시 request handler method 가 실행되록 작성
    @PostMapping("sub3")
    public String sub3(String city,
                       @RequestParam("uploadFile[]") MultipartFile[] files) {
        System.out.println("city = " + city);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub4")
    public String sub4(MyBean311 dto) {
        System.out.println("dto.getId() = " + dto.getId());
        System.out.println("dto.getUserName() = " + dto.getUserName());
        System.out.println("dto.getAddress() = " + dto.getAddress());
        MultipartFile[] uploadsFile = dto.getUploadsFile();
        if (uploadsFile != null && uploadsFile.length > 0) {
            for (MultipartFile file : uploadsFile) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;
    }

    // 연습: post /api/main31/sub5 의 요청을 다루는 메소드 만들기
    // request parameters 는 dto(MyBean312) 받기
    @PostMapping("sub5")
    public String sub5(MyBean312 dto) {
        System.out.println("dto.getClassName() = " + dto.getClassName());
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getLocation() = " + dto.getLocation());

        MultipartFile[] uploads = dto.getUploads();
        if (uploads != null && uploads.length > 0) {
            for (MultipartFile file : uploads) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;
    }

    // queryString이 여러개 일경우,
    // @PathVariable 로 받을 수 있다.
    @GetMapping("sub6/{city}")
    public String sub6(@PathVariable String city) {
        System.out.println("city = " + city);
        System.out.println("Controller31.sub6");
        return null;
    }

    // 연습: react 에서 get /api/main31/sub7/33
    // 연습: react 에서 get /api/main31/sub7/66
    // 연습: react 에서 get /api/main31/sub7/88
    @GetMapping("sub7/{id}")
    public String sub7(@PathVariable Integer id) {
        System.out.println("id = " + id);
        return null;
    }
}
