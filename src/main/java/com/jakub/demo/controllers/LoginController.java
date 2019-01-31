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
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public LoginController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login/signup";
    }

    @PostMapping("/registered")
    public String processForm(@Valid User user, BindingResult result, Model model) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "login/signup";
        }
        userService.saveUser(user);
        return "login/registered";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {

        return "login/signin";
    }

    @RequestMapping(value = "/signedout")
    public String signedOut() {

        return "login/signedout";
    }

    @RequestMapping(value = "/403")
    public String accessDenied() {

        return "login/accessdenied";
    }




}
