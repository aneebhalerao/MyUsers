package com.user.user.controllers;

import com.user.user.Entity.UsersDetailEntity;
import com.user.user.model.User;
import com.user.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
public class UserDataController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String getUserDetails() {
        List<UsersDetailEntity> users = userService.getUsers();
        return users.toString();
    }

    @PostMapping("/save")
    public void upsertUser(@RequestBody UsersDetailEntity user) {
        userService.saveUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UsersDetailEntity user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
