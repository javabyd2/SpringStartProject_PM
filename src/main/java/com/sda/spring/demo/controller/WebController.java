package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private AuthorService authorService;


    @GetMapping(value = "/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/web/authors")
    public ModelAndView authors(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "authorsList",
                        authorService.getAuthors()
                        );
        modelAndView.setViewName("authors");

        return modelAndView;
    }

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/web/addrole")
    public String addRole(@ModelAttribute("role")Role role,
                          RedirectAttributes redirectAttributes
                          ){

        roleService.save(role);
        redirectAttributes.addFlashAttribute("message",
                "Dodano pomyślnie");

        return "redirect:/web/roleform";
    }

    @GetMapping(value = "/web/roleform")
    public ModelAndView roleForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleform");
        modelAndView.addObject("role", new Role());

        return modelAndView;
    }


}
