package com.vmg.myblog.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ImageBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageName;
    @ManyToOne
    private Blog blog;
}
