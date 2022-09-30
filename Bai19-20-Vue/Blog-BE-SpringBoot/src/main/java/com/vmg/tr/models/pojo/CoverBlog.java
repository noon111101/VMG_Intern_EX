package com.vmg.tr.models.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CoverBlog extends BasePOJO {
    @Column(nullable = false)
    private String coverName;
    @ManyToOne
    private Blog blog;
}
