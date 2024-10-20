package com.api.redis.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User implements Serializable {
    // Getters and Setters
    private String id;
    private String name;
    private int age;

    // Constructors
    public User() {}

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
