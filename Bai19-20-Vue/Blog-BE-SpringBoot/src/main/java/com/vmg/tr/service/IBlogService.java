package com.vmg.tr.service;

import com.vmg.tr.payload.response.BlogResponse;
import com.vmg.tr.models.dto.BlogDTO;
import com.vmg.tr.payload.request.BlogRequest;
import com.vmg.tr.models.pojo.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogRequest blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
    List<BlogDTO> findByCategory(Long id);

    BlogResponse findAll(Pageable pageable);
}
