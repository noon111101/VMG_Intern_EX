package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> getAll();
    void save(Blog blog);
    void delete(Integer id);
    Optional<Blog> findById(Integer id);
}
