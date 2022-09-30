package com.vmg.tr.models.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.vmg.tr.models.pojo.Category} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends BaseDTO<CategoryDTO> implements Serializable {
    private String name;
    private String code;
    private List<BlogDTO> blogs;
}