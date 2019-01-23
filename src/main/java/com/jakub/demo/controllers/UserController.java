package com.jakub.demo.controllers;

import com.jakub.demo.entity.User;
import com.jakub.demo.repositories.UserRepository;
import com.jakub.demo.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public PasswordService passwordService;


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
        passwordService.saveUserHashedPassword(user);
        return "users/registered";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/signin";
    }

    @PostMapping("/signedin")
    @ResponseBody
    public String processLogin(@Valid User user, BindingResult result, Model model) {
        User username = userRepository.findByUsername(user.getUsername());
        String exist = Boolean.toString(passwordService.checkPassword(username, user.getPassword()));
        model.addAttribute("user", user);

//        if (result.hasErrors()) {
//            return "users/singin";
//        }
        return exist;
        //return "users/registered";
    }
}
