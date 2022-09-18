package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Cover;

public interface ICoverService {
    public Cover save(Cover cover);

    public void deleteByBlogID(Blog blog);
}
