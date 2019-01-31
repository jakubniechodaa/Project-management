package com.jakub.demo.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(Model model) {
        return "index";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/main")
    public String loggedMain(Model model) {
        return "index2";
    }

}
