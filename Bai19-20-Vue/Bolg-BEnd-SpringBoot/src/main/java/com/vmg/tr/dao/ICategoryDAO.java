package com.vmg.tr.dao;

import com.vmg.tr.models.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDAO extends JpaRepository<Category, Long> {
    Category findOneByCode(String categoryCode);
}
