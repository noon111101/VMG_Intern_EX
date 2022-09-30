package com.vmg.tr.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BlogRequest {
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String title;
    @NotEmpty
    private MultipartFile[] cover;
    @NotEmpty
    private String content;
    @NotNull
    private String categoryCode;
}
