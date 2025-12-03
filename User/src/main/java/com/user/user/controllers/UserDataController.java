package com.user.user.controllers;

import com.user.user.model.User;
import com.user.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("user")
public class UserDataController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String getUserDetails() {
        List<User> users = userService.getUsers();
        return users.toString();
    }

    @PostMapping("/upsert")
    public void upsertUser(@RequestBody User user) {
        userService.upsertUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
