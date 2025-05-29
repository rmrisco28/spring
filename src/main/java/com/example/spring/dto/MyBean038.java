package com.example.spring.dto;

public class MyBean038 {
    // 필드에 nickName, password
    // 프로퍼티 목록: name(읽기,쓰기), pw(읽기,쓰기), decription(읽기만)
    private String nickName;
    private String password;

    public String getName() {
        return nickName;
    }

    public void setName(String name) {
        this.nickName = name;
    }

    public String GetPw() {
        return password;
    }

    public void SetPw(String pw) {
        this.password = pw;
    }

    public String setDescription() {
        return nickName + "," + password;
    }
}
