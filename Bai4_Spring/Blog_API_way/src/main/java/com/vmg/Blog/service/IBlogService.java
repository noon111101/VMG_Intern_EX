package com.vmg.Blog.service;

import com.vmg.Blog.model.Blog;

import java.util.List;

public interface IBlogService {

    Blog save(Blog blog);
    void delete(long[] ids);
    void delete(Long id);

    List<Blog> findAll();
}
