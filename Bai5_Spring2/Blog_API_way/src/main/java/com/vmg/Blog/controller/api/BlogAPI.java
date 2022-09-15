package com.vmg.Blog.controller.api;

import com.vmg.Blog.model.Blog;
import com.vmg.Blog.service.IBlogService;
import com.vmg.Blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BlogAPI {
    @Autowired
    BlogService blogService;

    @PostMapping("/create")
    public Blog save(@Valid @RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @PutMapping("/update")
    public Blog update( @RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestBody long[] id) {
        System.out.println(id);
        blogService.delete(id);
    }
}

