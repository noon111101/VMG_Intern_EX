package com.vmg.tr.dao;

import com.vmg.tr.models.pojo.CoverBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoverBlogDAO extends JpaRepository<CoverBlog, Long> {
}