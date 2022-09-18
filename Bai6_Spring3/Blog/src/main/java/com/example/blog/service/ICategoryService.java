package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();

    void save(Category category);

    void delete(Integer id);

    Optional<Category> findById(Integer id);
}
