package com.jakub.demo.controllers;

import com.jakub.demo.CurrentUser;
import com.jakub.demo.entity.Status;
import com.jakub.demo.entity.Task;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.StatusRepository;
import com.jakub.demo.repositories.TaskRepository;
import com.jakub.demo.services.ProjectService;
import com.jakub.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
@Secured("ROLE_USER")
public class TaskController {

    private final ProjectRepository projectRepository;
    private ProjectService projectService;
    private TaskRepository taskRepository;
    private StatusRepository statusRepository;
    private TaskService taskService;

    @Autowired
    public TaskController(ProjectRepository projectRepository, ProjectService projectService, TaskRepository taskRepository, StatusRepository statusRepository, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.taskRepository = taskRepository;
        this.statusRepository = statusRepository;
        this.taskService = taskService;
    }



    @RequestMapping(value= "/add/{id}", method = RequestMethod.GET)
    public String main(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable long id,Model model) {
        Task task = new Task();
        List<Status> statuses = statusRepository.findAllByActive(true);
        User user = currentUser.getUser();
        model.addAttribute("statuses", statuses);
        model.addAttribute("task", task);
        model.addAttribute("project.id", id);
        model.addAttribute("user.id", user.getId() );
        return "tasks/add";
    }

    @PostMapping("/added")
    public String processForm(@Valid Task task, BindingResult result, Model model) {
//        User entityUser = currentUser.getUser();
        model.addAttribute("task", task);
        if (result.hasErrors()) {
            return "tasks/add";
        }
        //taskService.saveTask(entityUser, task);
        taskRepository.save(task);
        return "tasks/added";
    }


}
