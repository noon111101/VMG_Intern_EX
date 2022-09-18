package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Cover;
import com.example.blog.repository.CoverRepository;
import com.example.blog.service.ICoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverServiceImpl implements ICoverService {
    @Autowired
    private CoverRepository coverRepository;
    @Override
    public Cover save(Cover cover) {
        return coverRepository.save(cover);
    }

    @Override
    public void deleteByBlogID(Blog blog) {
        List<Cover> listCovers = coverRepository.findAll();
        for (Cover c: listCovers) {
            if(c.getBlog().getId() == blog.getId()){
                coverRepository.deleteById(c.getId());
            }
        }

    }
}
