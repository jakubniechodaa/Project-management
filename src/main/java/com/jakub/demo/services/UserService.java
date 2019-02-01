package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User findByUsername(String name);
    void saveUser(User user);
    Set<User> findUsersByRoleUser(Long project_id);
}