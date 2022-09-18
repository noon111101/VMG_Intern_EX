package com.example.blog.controller;

import com.example.blog.service.ICoverService;
import com.example.blog.form.BlogForm;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.model.Cover;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
@Slf4j
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private ICoverService iCoverService;
    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/index")
    public ModelAndView listBlogs(Model model, @RequestParam("cateid") Optional<Integer> cateid) {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Blog> listBlog = new ArrayList<>();
        model.addAttribute("listCategory", iCategoryService.getAll());

        if (cateid.isPresent() && cateid.get() != 0) {
//            listBlog = iBlogService.getBlogByCategoryId(cateid);
//            modelAndView.addObject("listBlogs", iCategoryService.findById(cateid.get()).get().getBlog());
            listBlog = iCategoryService.findById(cateid.get()).get().getBlog();
            model.addAttribute("cateSelected", cateid);
        } else {
            listBlog = iBlogService.getAll();
        }
        model.addAttribute("listBlogs", listBlog);
        return modelAndView;
    }

    @GetMapping("/addblog")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/add-blog");
        modelAndView.addObject("blog", new BlogForm());
        modelAndView.addObject("listCategory", iCategoryService.getAll());
        return modelAndView;
    }


    @PostMapping("/addblog")
    public String addBLog(@ModelAttribute("blog") @Valid @RequestBody BlogForm blogForm, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("listCategory", iCategoryService.getAll());
            return "add-blog";
        }
        Blog blog = new Blog.BlogBuilder(blogForm.getTitle())
                .content(blogForm.getContent()).build();
        blog.setCategory(blogForm.getCategory());
        iBlogService.save(blog);
        System.out.println(blogForm.getCategory().getName());
        for (MultipartFile file : blogForm.getFiles()) {
            String fileName = file.getOriginalFilename();
            var is = file.getInputStream();
            try {
                Files.copy(is, Paths.get(this.fileUpload + fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Cover cover = new Cover(fileName, blog);
            iCoverService.save(cover);
        }

        return "redirect:/blogs/index";
    }


    @GetMapping("/editblog/{id}")
    public String showUpdateBlogForm(@PathVariable("id") int id, Model model) {
        Blog blog = iBlogService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog id:" + id));
        List<Category> listCate = iCategoryService.getAll();
        List<Category> listCate1 = new ArrayList<>();
        for (Category category : listCate) {
            if (category.getId() != blog.getCategory().getId()) {
                listCate1.add(category);
            }
        }
        model.addAttribute("listCategory", listCate1);
        model.addAttribute("blog", blog);
        return "update-blog";
    }

    @PostMapping("updateblog/{id}")
    public String updateBlog(@PathVariable("id") int id, @Validated Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listCategory", iCategoryService.getAll());
            return "update-blog";
        }

        iBlogService.save(blog);
        return "redirect:/blogs/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id, Model model) {

        Blog blog = iBlogService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + id));
        iCoverService.deleteByBlogID(blog);
        iBlogService.delete(id);
        return "redirect:/blogs/index";
    }


}
