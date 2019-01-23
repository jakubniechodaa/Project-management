package com.jakub.demo.services;

import com.jakub.demo.entity.User;

import java.util.List;

public interface PasswordService {

    public void saveUserHashedPassword(User user);
    public boolean checkPassword(User user, String text);

}

