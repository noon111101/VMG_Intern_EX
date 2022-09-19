package com.vmg.myblog.controller.api;

import com.vmg.myblog.exception.FileNullException;
import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.BlogDTO;
import com.vmg.myblog.model.BlogForm;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogAPI {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @PostMapping(value = "create")
    public ResponseEntity<?> save(@Valid @ModelAttribute BlogForm blogForm, BindingResult bindingResult) {
        MultipartFile[] files = blogForm.getCover();
        if (Arrays.stream(files).toList().get(0).getSize() <=0) {
            bindingResult.addError(new FieldError("blogForm", "files","File can't not null"));
        }
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(blogService.save(blogForm));
    }
    @PutMapping(value = "update")
    public BlogDTO update( @ModelAttribute BlogForm blogForm) {
        return blogService.save(blogForm);
    }

    @DeleteMapping("delete")
    public ResponseEntity delete (@RequestBody long[] ids) {
        blogService.delete(ids);
        return ResponseEntity.ok("true");
    }
    @GetMapping("page")
    public ResponseEntity<Page<Blog>> findBlogPage(Pageable pageable){
        Page<Blog> blogs=blogService.findBlogPage(pageable);
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    };

}
