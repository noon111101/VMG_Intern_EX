package com.vmg.myblog.service;

import com.vmg.myblog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category save(Category category);
    void delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
    Category findOneByName(String categoryName);
}
