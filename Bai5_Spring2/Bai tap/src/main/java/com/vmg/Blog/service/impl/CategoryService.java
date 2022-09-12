package com.vmg.Blog.service.impl;

import com.vmg.Blog.model.Category;
import com.vmg.Blog.repository.ICategoryRepository;
import com.vmg.Blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public Category save(Category category) {
        category=iCategoryRepository.save(category);
        return category;
    }

    @Override
    public void delete(Long id) {
        iCategoryRepository.deleteById(id);
    }
}
