package com.vmg.myblog.repository;

import com.vmg.myblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findOneByName(String categoryName);
}
