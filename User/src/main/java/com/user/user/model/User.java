package com.user.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    int id;
    String name;
    int age;
    String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
