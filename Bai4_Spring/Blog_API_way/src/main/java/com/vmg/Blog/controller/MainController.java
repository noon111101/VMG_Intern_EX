package com.vmg.Blog.controller;

import com.vmg.Blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    IBlogRepository blogRepository;

    @GetMapping("/index")
    public String showBlogList(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "index";
    }

}

