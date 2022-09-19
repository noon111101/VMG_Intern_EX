package com.vmg.myblog.service;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.Category;
import com.vmg.myblog.model.ImageBlog;

import java.util.List;
import java.util.Optional;

public interface IImageBlogService {
    ImageBlog save(String filename, Blog blog);
    void delete(Long id);
    List<ImageBlog> findAll();
    Optional<ImageBlog> findById(Long id);

    void delete(ImageBlog imageBlog);
}
