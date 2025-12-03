package com.user.user.services;

import com.user.user.model.User;
import com.user.user.util.UserUtility;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    List<User> users;
    public List<User> getUsers() {
        return UserUtility.getUsers();
    }

    public void upsertUser(User user) {
        users = getUsers();
        User userfetched = UserUtility.getUserById(user.getId());
        if(userfetched == null) {
            users.add(user);
        } else {
            users.remove(userfetched);
            users.add(user);
        }
    }

    public void deleteUser(int id) {
        User userfetched = UserUtility.getUserById(id);
        if(users == null || users.isEmpty()) {
            users = getUsers();
        }
        users.remove(userfetched);
    }
 }
