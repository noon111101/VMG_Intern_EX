package com.vmg.myblog.repository;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.ImageBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageBlogRepository extends JpaRepository<ImageBlog, Long> {
}
