package com.jakub.demo;

import java.util.Collection;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class CurrentUser extends User {

    private final com.jakub.demo.entity.User user;

    public CurrentUser(String username, String password, Collection<?
            extends GrantedAuthority> authorities,
                       com.jakub.demo.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public com.jakub.demo.entity.User getUser() {return user;}
}