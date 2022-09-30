package com.vmg.tr.models.dto;

import com.vmg.tr.models.pojo.BasePOJO;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link BasePOJO} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO<T> implements Serializable {
    private Long id;
    private Date createDate;
    private Date modifiedDate;
    private String createBy;
    private String modifiedBy;
}