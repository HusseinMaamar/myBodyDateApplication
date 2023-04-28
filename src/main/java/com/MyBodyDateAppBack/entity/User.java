package com.MyBodyDateAppBack.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("user")
public class User {
    @Id
    private String id;
    private  String name;
    private  String email;
    private  Number age;

    public String getId() {
        return id;
    }


    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
    }
}
