package com.jakub.demo.services;

import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUserHashedPassword(User user){

        String password = user.getPassword();
        String salt = BCrypt.gensalt();
        user.setSalt(salt);
        String hashed = BCrypt.hashpw(password, salt);
        user.setPassword(hashed);
        userRepository.save(user);
    }

    @Override
    public boolean checkPassword(User user, String text){

        if (BCrypt.checkpw(text, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
