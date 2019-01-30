package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;


public interface ProjectService {
    void saveProject(User user, Project project);

}