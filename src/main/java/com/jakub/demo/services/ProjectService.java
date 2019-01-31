package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;

import java.util.List;


public interface ProjectService {
    void saveProject(User user, Project project);
    List<Project> findProjectsByUser(User user);

}