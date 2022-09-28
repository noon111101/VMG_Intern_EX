package com.vmg.myblog.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
public class BlogForm {

    private Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String title;
    @NotEmpty
    private MultipartFile[] cover;
    @NotEmpty
    private String content;
    @NotNull
    private Long categoryId;
}
