package com.vmg.Blog.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class BlogForm {


    private String title;

    private String content;

    private MultipartFile cover;

    private Category category;

    public BlogForm() {
    }

    public BlogForm(BlogFormBuilder blogFormBuilder) {

        this.title = blogFormBuilder.title;
        this.content = blogFormBuilder.content;
        this.cover = blogFormBuilder.cover;
        this.category = blogFormBuilder.category;
    }

    public static class BlogFormBuilder {

        private String title;

        private String content;

        private MultipartFile cover;

        private Category category;

        public BlogFormBuilder( String title, String content, Category category) {
            this.title = title;
            this.content = content;
            this.category = category;
        }

        public BlogFormBuilder cover(MultipartFile cover) {
            this.cover = cover;
            return this;
        }
        public BlogForm build() {
            return new BlogForm(this);
        }

    }
}
