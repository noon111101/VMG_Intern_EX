package com.vmg.tr.payload.response;

import com.vmg.tr.models.dto.BlogDTO;

import java.util.List;

public class BlogResponse {
    private Long totalItems;
    private int totalPages;
    private int currentPage;
    private List<BlogDTO> blogDTOList;

    public BlogResponse() {
    }

    public BlogResponse(Long totalItems, int totalPages, int currentPage, List<BlogDTO> blogDTOList) {
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.blogDTOList = blogDTOList;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<BlogDTO> getBlogDTOList() {
        return blogDTOList;
    }

    public void setBlogDTOList(List<BlogDTO> blogDTOList) {
        this.blogDTOList = blogDTOList;
    }
}
