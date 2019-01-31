package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<Project> findProjectsByUser(User user){

        List<Project> projects = projectRepository.findProjectsByActive(true);
        List<Project> userProjects = new ArrayList<>();
        for (Project project : projects){
            for(User us : project.getUsers()){
                if (us.getId() == user.getId()){
                    userProjects.add(project);
                }
            }
        }
        return userProjects;
    }
}
