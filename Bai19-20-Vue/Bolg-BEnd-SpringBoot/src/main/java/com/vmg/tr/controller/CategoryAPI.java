package com.vmg.tr.controller;

import com.vmg.tr.models.pojo.Category;
import com.vmg.tr.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/category")
public class CategoryAPI {
    private final ICategoryService categoryService;

    public CategoryAPI(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Category>> getAll()
    {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}