package com.jakub.demo.controllers;

import com.jakub.demo.CurrentUser;
import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.Role;
import com.jakub.demo.entity.Task;
import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.ProjectRepository;
import com.jakub.demo.repositories.RoleRepository;
import com.jakub.demo.repositories.TaskRepository;
import com.jakub.demo.repositories.UserRepository;
import com.jakub.demo.services.ProjectService;
import com.jakub.demo.services.UserService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/projects")
@Secured("ROLE_USER")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private ProjectService projectService;
    private UserService userService;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TaskRepository taskRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, ProjectService projectService, UserService userService, UserRepository userRepository, RoleRepository roleRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.taskRepository = taskRepository;
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

    @RequestMapping(value= "/my")
    public String userProjects(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User entityUser = currentUser.getUser();
        model.addAttribute("project", projectService.findProjectsByUser(entityUser));
        return "projects/my";
    }

    @RequestMapping(value= "/my/{id}")
    public String userProjectDetails(@PathVariable Long id, Model model) {
        Project project = projectRepository.findProjectsById(id);
        List<Task> tasks = taskRepository.findTasksByProjectId(id);
        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);

        return "projects/projectDetails";
    }

    ////////WORKING ON ADDING USER
    @RequestMapping(value= "/adduser/{id}", method = RequestMethod.GET)
    public String addUserToProject(@PathVariable Long id, Model model) {
//        Set<User> users = userService.findUsersByRoleUser(id);
//        Role role = roleRepository.findByName("USER");
//        Set<User> users1 = userRepository.findUsersByRoles(role);
        User user = new User();
        List<User> users1 = userRepository.findAll();
        Set<User> set = new HashSet<>();
        set.addAll(users1);
        Project project = projectRepository.findProjectsById(id);
        model.addAttribute("users1", set);
        model.addAttribute("user", user);
        return "projects/adduser";
    }

    @PostMapping("/edited")
    public String processEditedForm(@Valid User user, BindingResult result, Model model) {//@Valid Project project

        model.addAttribute("user", user);//project,project
        if (result.hasErrors()) {
            return "projects/add";//tu rozkminic z ID
        }
       // projectRepository.save(project);
        return "projects/added";
    }

}
