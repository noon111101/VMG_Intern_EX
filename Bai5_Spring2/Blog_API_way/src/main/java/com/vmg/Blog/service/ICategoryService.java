package com.vmg.Blog.service;

import com.vmg.Blog.model.Category;

public interface ICategoryService {
    Category save(Category category);
    void delete(Long id);

}
