package com.vmg.tr.models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Blog extends BasePOJO {
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(length = 20,nullable = false)
    private String title;
    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "blog")
    private List<CoverBlog> coverBlogs;
}
