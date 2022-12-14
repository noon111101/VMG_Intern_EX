package com.example.blog.service.impl;

import com.example.blog.repository.BlogRepository;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);

    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> getBlogByCategoryId(Integer categoryID) {
        List<Blog> list = blogRepository.findAll();
        List<Blog> list1 = new ArrayList<>();
        for (Blog b: list) {
            if(b.getCategory().getId() == categoryID){
                list1.add(b);
            }
        }
        return list1;
    }
}
