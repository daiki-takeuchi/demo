package com.example.service;

/**
 * Created by DaikiTakeuchi on 2016/11/23.
 */
public class PageBean {

    private int totalCount;
    private int currentPage;
    private int maxPage;

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getMaxPage() {
        return maxPage;
    }
    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
