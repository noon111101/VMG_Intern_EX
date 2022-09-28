package com.vmg.myblog.repository;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByCategoryId(Long id);

    List<Blog> findAllByTitle(String title);
}
