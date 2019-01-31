package com.jakub.demo.services;

import com.jakub.demo.entity.Task;
import com.jakub.demo.entity.User;


public interface TaskService {
    void saveTask(User user, Task task);

}