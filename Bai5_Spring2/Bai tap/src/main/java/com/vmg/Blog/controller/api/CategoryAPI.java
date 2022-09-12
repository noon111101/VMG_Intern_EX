package com.vmg.Blog.controller.api;


import com.vmg.Blog.model.Category;
import com.vmg.Blog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public Category save( @RequestBody Category category) {
        return categoryService.save(category);
    }

}
