package com.maven01.web.bean;

import java.util.Date;

public class ArticleBlock 
{
	
    private Integer blockId;
    private Integer articleId;
    private Integer blockType;
    private String blockContent;
    private Date date;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getBlockType() {
        return blockType;
    }

    public void setBlockType(Integer blockType) {
        this.blockType = blockType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBlockContent() {
        return blockContent;
    }

    public void setBlockContent(String blockContent) {
        this.blockContent = blockContent == null ? null : blockContent.trim();
    }
    
}




