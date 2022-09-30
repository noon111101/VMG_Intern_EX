package com.vmg.tr.service;

import com.vmg.tr.models.pojo.Blog;
import com.vmg.tr.models.pojo.CoverBlog;

import java.util.List;
import java.util.Optional;

public interface ICoverBlogService {
    CoverBlog save(String filename, Blog blog);
    void delete(Long id);
    List<CoverBlog> findAll();
    Optional<CoverBlog> findById(Long id);

    void delete(CoverBlog coverBlog);
}
