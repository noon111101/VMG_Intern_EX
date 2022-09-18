package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> getAll();
    void save(Blog blog);
    void delete(Integer id);
    Optional<Blog> findById(Integer id);

    List<Blog> getBlogByCategoryId(Integer categoryID);
}
