package com.jakub.demo.services;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.Task;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.TaskRepository;
import com.jakub.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveTask(User user, Task task) {
        task.setUser(user);
        taskRepository.save(task);
    }

}
