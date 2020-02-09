package com.example.mvcjsp;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
    private String name;
    private String id;
    private String pw;
    private String email;

    public Member() {
        System.out.println("created member");
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public void setId(String id) {
        System.out.println("set id");
        this.id = id;
    }

    public void setPw(String pw) {
        System.out.println("set pw");
        this.pw = pw;
    }

    public void setEmail(String email) {
        System.out.println("set email");
        this.email = email;
    }
}
