package com.vmg.myblog.service.impl;

import com.vmg.myblog.model.*;
import com.vmg.myblog.repository.IBlogRepository;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import com.vmg.myblog.service.IImageBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    FileManagerService fileManagerService;
    @Autowired
    IImageBlogService imageBlogService;

    @Override
    public BlogDTO save(BlogForm blogForm) {
        BlogDTO blogDTO = modelMapper.map(blogForm, BlogDTO.class);
        List<String> filenames = fileManagerService.save("images", blogForm.getCover());
        Blog blog = convertToModel(blogDTO);
        blog = blogRepository.save(blog);
        for (String filename:filenames) {
            imageBlogService.save(filename, blog);
        }
        return convertToDTO(blog);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
//            fileManagerService.delete("images", String.valueOf(this.findById(id).getCover()));
            Blog blog = blogRepository.getReferenceById(id);
            for (ImageBlog imageBlog:blog.getImageBlogs()) {
                fileManagerService.delete("images", imageBlog.getImageName());
                imageBlogService.delete(imageBlog);
            }
            blogRepository.deleteById(id);
        }
    }

    @Override
    public List<BlogDTO> findAll() {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        List<Blog> blogList = blogRepository.findAll();
        for(Blog blog: blogList) {
            BlogDTO blogDTO = convertToDTO(blog);
            List<String> images = new ArrayList<>();
            for (ImageBlog imageBlog: blog.getImageBlogs()) {
                images.add(imageBlog.getImageName());
            }
            blogDTO.setImages(images);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.getReferenceById(id);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);

        blogDTO.setCategoryId(blog.getCategory().getId());
        return blogDTO;
    }

    private Blog convertToModel(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        if (blogDTO.getId() != null) {
            Blog oldBlog = blogRepository.getReferenceById(blogDTO.getId());
            for(ImageBlog imageBlog: oldBlog.getImageBlogs()) {
                fileManagerService.delete("images", imageBlog.getImageName());
            }
            blog.setId(oldBlog.getId());
        }
        Category category = categoryService.findById(blogDTO.getCategoryId());
        blog.setCategory(category);
        return blog;
    }

    @Override
    public List<BlogDTO> findByCategory(Long id) {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        List<Blog> blogList = blogRepository.findByCategoryId(id);
        for(Blog blog: blogList) {
            BlogDTO blogDTO = convertToDTO(blog);
            List<String> images = new ArrayList<>();
            for (ImageBlog imageBlog: blog.getImageBlogs()) {
                images.add(imageBlog.getImageName());
            }
            blogDTO.setImages(images);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }

    @Override
    public List<Blog> findAllByTitle(String title) {
        return blogRepository.findAllByTitle(title);
    }

    @Override
    public Page<Blog> findBlogPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
