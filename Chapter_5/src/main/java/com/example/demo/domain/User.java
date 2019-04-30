package com.example.demo.domain;


import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int age;
    private static final long serialVersionUID = -2731598327208972274L;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}