package com.vmg.tr.controller;

import com.vmg.tr.payload.response.BlogResponse;
import com.vmg.tr.models.dto.BlogDTO;
import com.vmg.tr.payload.request.BlogRequest;
import com.vmg.tr.service.IBlogService;
import com.vmg.tr.service.ICategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogAPI {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogAPI(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("blogList")
    public ResponseEntity<BlogResponse> getAll(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "2") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(blogService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> save(@Valid @ModelAttribute BlogRequest blogFormInput, BindingResult bindingResult) {
        MultipartFile[] files = blogFormInput.getCover();
        if (files == null) {
            bindingResult.addError(new FieldError("blogForm", "files","File can't not null"));
        }
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(blogService.save(blogFormInput));
    }
    @PutMapping(value = "update/{id}")
    public BlogDTO update(@ModelAttribute BlogRequest blogFormInput, @PathVariable Long id) {
        blogFormInput.setId(id);
        return blogService.save(blogFormInput);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete (@RequestBody long[] ids) {
        blogService.delete(ids);
        return ResponseEntity.ok("true");
    }
}
