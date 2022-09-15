package com.vmg.Blog.service.impl;

import com.vmg.Blog.model.Blog;
import com.vmg.Blog.repository.IBlogRepository;
import com.vmg.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog save(Blog blog) {
        blog = blogRepository.save(blog);
        return blog;
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            blogRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }
}
