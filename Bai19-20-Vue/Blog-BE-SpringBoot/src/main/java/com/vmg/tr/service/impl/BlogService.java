package com.vmg.tr.service.impl;

import com.vmg.tr.dao.IBlogDAO;
import com.vmg.tr.payload.response.BlogResponse;
import com.vmg.tr.models.dto.BlogDTO;
import com.vmg.tr.payload.request.BlogRequest;
import com.vmg.tr.models.pojo.Blog;
import com.vmg.tr.models.pojo.Category;
import com.vmg.tr.models.pojo.CoverBlog;
import com.vmg.tr.service.IBlogService;
import com.vmg.tr.service.ICategoryService;
import com.vmg.tr.service.ICoverBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    private final IBlogDAO blogDAO;
    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;
    private final FileManagerService fileManagerService;
    private final ICoverBlogService coverBlogService;

    public BlogService(IBlogDAO blogDAO, ICategoryService categoryService, ModelMapper modelMapper, FileManagerService fileManagerService, ICoverBlogService coverBlogService) {
        this.blogDAO = blogDAO;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.fileManagerService = fileManagerService;
        this.coverBlogService = coverBlogService;
    }

    @Override
    public BlogDTO save(BlogRequest blogFormInput) {
        BlogDTO blogDTO = modelMapper.map(blogFormInput, BlogDTO.class);
        List<String> filenames = fileManagerService.save("images", blogFormInput.getCover());
        Blog blog = convertToModel(blogDTO);
        blog = blogDAO.save(blog);
        for (String filename:filenames) {
            coverBlogService.save(filename, blog);
        }
        return convertToDTO(blog);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
//            fileManagerService.delete("images", String.valueOf(this.findById(id).getCover()));
            Blog blog = blogDAO.getReferenceById(id);
            for (CoverBlog coverBlog:blog.getCoverBlogs()) {
                fileManagerService.delete("images", coverBlog.getCoverName());
                coverBlogService.delete(coverBlog);
            }
            blogDAO.deleteById(id);
        }
    }

    @Override
    public List<BlogDTO> findAll() {

        List<Blog> blogList = blogDAO.findAll();
        return getBlogDTOList( blogList);
    }

    @Override
    public BlogResponse findAll(Pageable pageable) {
        Page<Blog> blogPage = blogDAO.findAll(pageable);
        BlogResponse blogFormOutput = new BlogResponse();
        blogFormOutput.setTotalItems(blogPage.getTotalElements());
        blogFormOutput.setTotalPages(blogPage.getTotalPages());
        blogFormOutput.setCurrentPage(blogPage.getNumber());
        blogFormOutput.setBlogDTOList(getBlogDTOList(blogPage.getContent()));
        return blogFormOutput;
    }

    @Override
    public Blog findById(Long id) {
        return blogDAO.getReferenceById(id);
    }
    @Override
    public List<BlogDTO> findByCategory(Long id) {

        List<Blog> blogList = blogDAO.findByCategoryId(id);
        return getBlogDTOList( blogList);
    }
    private List<BlogDTO> getBlogDTOList( List<Blog> blogList) {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for(Blog blog: blogList) {
            BlogDTO blogDTO = convertToDTO(blog);
            List<String> images = new ArrayList<>();
            for (CoverBlog coverBlog: blog.getCoverBlogs()) {
                images.add(coverBlog.getCoverName());
            }
            blogDTO.setCoverNameList(images);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }

    private Blog convertToModel(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        if (blogDTO.getId() != null) {
            Blog oldBlog = blogDAO.getReferenceById(blogDTO.getId());
            for(CoverBlog coverBlog: oldBlog.getCoverBlogs()) {
                fileManagerService.delete("images", coverBlog.getCoverName());
            }
            blog.setId(oldBlog.getId());
            blog.setCreateDate(oldBlog.getCreateDate());
        }
        Category category = categoryService.findOneByCode(blogDTO.getCategoryCode());
        blog.setCategory(category);
        return blog;
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);

        blogDTO.setCategoryCode(blog.getCategory().getCode());
        return blogDTO;
    }

}
