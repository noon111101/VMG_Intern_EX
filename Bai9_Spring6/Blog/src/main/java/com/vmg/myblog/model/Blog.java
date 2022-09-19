package com.vmg.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Title is empty")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "blog")
    private List<ImageBlog> imageBlogs;
}
