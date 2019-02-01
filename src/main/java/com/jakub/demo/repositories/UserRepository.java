package com.jakub.demo.repositories;

import com.jakub.demo.entity.Role;
import com.jakub.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public	interface	UserRepository	extends	JpaRepository<User,	Long>	{
    User findByUsername(String username);
    Set<User> findUsersByRoles(Role role);
    List<User> findAll();
}
