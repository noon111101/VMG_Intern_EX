package com.vmg.tr.models.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.vmg.tr.models.pojo.Blog} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO extends BaseDTO<BlogDTO> implements Serializable {
    @NotBlank
    @Size(min = 3, max = 20)
    private String content;
    @NotBlank
    private String title;
    @NotBlank
    private String categoryCode;
    private List<String> coverNameList;
}