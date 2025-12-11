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
    public List<UsersDetailEntity> getUserDetails() {
        return userService.getUsers();
    }

    @PostMapping("/save")
    public UsersDetailEntity upsertUser(@RequestBody UsersDetailEntity user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    public UsersDetailEntity updateUser(@RequestBody UsersDetailEntity user) {
       return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
