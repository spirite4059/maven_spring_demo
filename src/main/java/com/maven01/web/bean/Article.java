package com.maven01.web.bean;

public class Article {
    private Integer articleId;

    private String articleName;

    private String articleList;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getArticleList() {
        return articleList;
    }

    public void setArticleList(String articleList) {
        this.articleList = articleList == null ? null : articleList.trim();
    }
}