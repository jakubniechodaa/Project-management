package com.jakub.demo.services;

import com.jakub.demo.entity.User;

public interface UserService {
    User findByUsername(String name);
    void saveUser(User user);
}