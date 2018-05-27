package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.service.*;
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
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/web/authors")
    public ModelAndView authors() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "authorsList",
                        authorService.getAuthors()
                );
        modelAndView.setViewName("authors");
        return modelAndView;
    }

    @GetMapping(value = "/web/users")
    public ModelAndView users() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "usersList",
                        userService.getUsers()
                );
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping(value = "/web/books")
    public ModelAndView books() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "booksList",
                        bookService.getBooks()
                );
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @GetMapping(value = "/web/categories")
    public ModelAndView categories() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "categoryList",
                        categoryService.getCategory()
                );
        modelAndView.setViewName("categories");
        return modelAndView;
    }

    @GetMapping(value = "/web/roles")
    public ModelAndView roles() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.
                addObject(
                        "rolesList",
                        roleService.getRoles()
                );
        modelAndView.setViewName("roles");
        return modelAndView;
    }

    @Autowired
    private RoleService roleService;


    @PostMapping(value = "/web/addrole")
    public String addRole(@ModelAttribute("role") Role role,
                          RedirectAttributes redirectAttributes
    ) {
        roleService.save(role);
        redirectAttributes.addFlashAttribute("message", "Dodano pomyslnie");

        return "redirect:/web/roleform";
    }

    @GetMapping(value = "/web/roleform")
    public ModelAndView roleform() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleform");
        modelAndView.addObject("role", new Role());

        return modelAndView;
    }

}
