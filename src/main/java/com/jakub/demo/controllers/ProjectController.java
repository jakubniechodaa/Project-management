package com.jakub.demo.controllers;

import com.jakub.demo.CurrentUser;
import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, ProjectService projectService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }



    @RequestMapping(value= "/add", method = RequestMethod.GET)
    public String main(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/add";
    }

    @PostMapping("/added")
    public String processForm(@AuthenticationPrincipal CurrentUser currentUser, @Valid Project project, BindingResult result, Model model) {

        User entityUser = currentUser.getUser();
        model.addAttribute("project", project);
        if (result.hasErrors()) {
            return "projects/add";
        }
        projectService.saveProject(entityUser, project);
        return "projects/added";
    }
}
