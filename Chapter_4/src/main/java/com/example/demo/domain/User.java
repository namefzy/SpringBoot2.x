package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private int age;
    private static final long serialVersionUID = -2731598327208972274L;
}
