package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Id
 *     @GeneratedValue(strategy = GenerationType.IDENTITY):自增策略
 * @Transient：不需要映射的字段
 */
@Data
@Entity(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String username;
    private int age;
    @Transient
    private String email;
    private static final long serialVersionUID = -2002450359448288708L;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
