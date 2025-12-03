package com.user.user.util;

import com.user.user.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtility {

    static List<User> users = new ArrayList<>();
    public static List<User> getUsers() {
        if(users.isEmpty()) {
            users.add(new User(1, "Ankita", 29, "hannover"));
            users.add(new User(2, "sai", 20, "hannover"));
            users.add(new User(3, "spar", 9, "hannover"));
            users.add(new User(4, "yug", 2, "hannover"));
        }
        return users;
    }

    public static User getUserById(int id) {
        return users.stream().filter(user -> id == user.getId()).findFirst().orElse(null);
    }
}
