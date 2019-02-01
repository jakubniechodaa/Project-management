package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.Role;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.RoleRepository;
import com.jakub.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProjectRepository projectRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository, ProjectRepository projectRepository, BCryptPasswordEncoder passwordEncoder) {
        this.projectRepository = projectRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByName("USER");
        HashSet<Role> roles = new HashSet<>(Arrays.asList(userRole));
        user.setRoles(roles);

        System.out.println(user.getRoles());

        userRepository.save(user);
    }

    @Override
    public Set<User> findUsersByRoleUser(Long project_id){
        Role role = roleRepository.findByName("USER");
        Project project = projectRepository.findProjectsById(project_id);
        Set<User> alreadySigned = project.getUsers();
        Set<User> users = userRepository.findUsersByRoles(role);
        users.removeAll(alreadySigned);
        return users;
    }


}