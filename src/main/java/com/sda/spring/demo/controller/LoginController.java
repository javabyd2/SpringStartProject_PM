package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = "login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
        }

    }

