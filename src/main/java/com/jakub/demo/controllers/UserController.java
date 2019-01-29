package com.jakub.demo.controllers;

import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.UserRepository;
import com.jakub.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public UserService userService;


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/signup";
    }

    @PostMapping("/registered")
    public String processForm(@Valid User user, BindingResult result, Model model) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "users/signup";
        }
        userService.saveUser(user);
        return "users/registered";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login() {
//        User user = new User();
//        model.addAttribute("user", user);
        return "users/signin";
    }



}
