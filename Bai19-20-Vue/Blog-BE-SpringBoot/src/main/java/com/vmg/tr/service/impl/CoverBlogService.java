package com.vmg.tr.service.impl;

import com.vmg.tr.dao.ICoverBlogDAO;
import com.vmg.tr.models.pojo.Blog;
import com.vmg.tr.models.pojo.CoverBlog;
import com.vmg.tr.service.ICoverBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoverBlogService implements ICoverBlogService {
    @Autowired
    ICoverBlogDAO coverBlogDAO;

    @Override
    public CoverBlog save(String filename, Blog blog) {
        CoverBlog coverBlog = new CoverBlog();
        coverBlog.setCoverName(filename);
        coverBlog.setBlog(blog);
        return coverBlogDAO.save(coverBlog);
    }

    @Override
    public void delete(Long id) {
        coverBlogDAO.deleteById(id);
    }

    @Override
    public List<CoverBlog> findAll() {
        return coverBlogDAO.findAll();
    }

    @Override
    public void delete(CoverBlog coverBlog) {
        coverBlogDAO.delete(coverBlog);
    }

    @Override
    public Optional<CoverBlog> findById(Long id) {
        return coverBlogDAO.findById(id);
    }
}
