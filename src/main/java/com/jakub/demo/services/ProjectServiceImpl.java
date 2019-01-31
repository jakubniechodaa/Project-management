package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveProject(User user, Project project) {

        //HashSet<User> users = new HashSet<>(Arrays.asList(user));
        Set<User> users = project.getUsers();
        users.add(user);
        project.setUsers(users);
        projectRepository.save(project);

        //HashSet<Project> projects = new HashSet<>(Arrays.asList(project));
        Set<Project> projects = user.getProjects();
        projects.add(project);
        user.setProjects(projects);
        userRepository.save(user);


    }
}
