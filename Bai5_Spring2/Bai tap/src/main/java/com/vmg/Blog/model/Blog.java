package com.vmg.Blog.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cover", nullable = false)
    private String cover;
    @Column(name = "content", nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getContent() {
        return content;
    }

    public Category getCategory() {
        return category;
    }

    public Blog(BlogBuilder blogBuilder) {
        this.id = blogBuilder.id;
        this.title = blogBuilder.title;
        this.cover = blogBuilder.cover;
        this.content = blogBuilder.content;
        this.category = blogBuilder.category;
    }

    public static class BlogBuilder{
        // required parameters
        private Long id;
        private String title;
        private String content;

        private Category category;

        //option parameters
        private String cover;

        public BlogBuilder(Long id, String title, String content,Category category) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.category=category;
        }

        public BlogBuilder cover(String cover) {
            this.cover = cover;
            return this;
        }
        public Blog build() {
            return new Blog(this);
        }
    }





}
