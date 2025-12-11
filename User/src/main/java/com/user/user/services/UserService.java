package com.user.user.services;

import com.user.user.Entity.UsersDetailEntity;
import com.user.user.Repository.UsersDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersDetailRepository userDetailsRspository;

    public List<UsersDetailEntity> getUsers() {
        return userDetailsRspository.findAll();
    }

    public UsersDetailEntity saveUser(UsersDetailEntity user) {
        return userDetailsRspository.save(user);
    }
    public UsersDetailEntity updateUser(UsersDetailEntity user) {
        return userDetailsRspository.save(user);
    }

    public void deleteUser(Long id) {
        userDetailsRspository.deleteById(id);
    }
 }
