package com.vmg.myblog.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class BlogDTO {
    private Long id;
    @NotBlank()
    @Size(min = 3, max = 20)
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private Long categoryId;
    private List<String> images;
}
