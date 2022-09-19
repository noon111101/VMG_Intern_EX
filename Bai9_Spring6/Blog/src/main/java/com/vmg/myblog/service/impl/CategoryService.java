package com.vmg.myblog.service.impl;

import com.vmg.myblog.model.Category;
import com.vmg.myblog.repository.ICategoryRepository;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    @Override
    public Category findOneByName(String categoryName) {
        return categoryRepository.findOneByName(categoryName);
    }
}
