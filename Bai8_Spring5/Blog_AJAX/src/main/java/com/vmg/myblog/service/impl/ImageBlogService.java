package com.vmg.myblog.service.impl;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.ImageBlog;
import com.vmg.myblog.repository.IImageBlogRepository;
import com.vmg.myblog.service.IImageBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageBlogService implements IImageBlogService {
    @Autowired
    IImageBlogRepository iImageBlogRepository;

    @Override
    public ImageBlog save(String filename, Blog blog) {
        ImageBlog imageBlog = new ImageBlog();
        imageBlog.setImageName(filename);
        imageBlog.setBlog(blog);
        return iImageBlogRepository.save(imageBlog);
    }

    @Override
    public void delete(Long id) {
        iImageBlogRepository.deleteById(id);
    }

    @Override
    public List<ImageBlog> findAll() {
        return iImageBlogRepository.findAll();
    }

    @Override
    public void delete(ImageBlog imageBlog) {
        iImageBlogRepository.delete(imageBlog);
    }

    @Override
    public Optional<ImageBlog> findById(Long id) {
        return iImageBlogRepository.findById(id);
    }
}
