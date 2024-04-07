package com.bootcamp.project.controller.implement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class Welcome {
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcome";
    }
    @GetMapping("/error")
    public String showError(){
        return "welcome";
    }
}
