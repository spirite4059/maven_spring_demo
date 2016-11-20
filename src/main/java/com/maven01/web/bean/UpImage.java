package com.maven01.web.bean;

import java.util.Date;

public class UpImage 
{
    private Integer imgId;
    private String imgName;
    private String imgDesp;
    private Integer imgType;
    private String imgUrl;
    private String imgThumbUrl;
    private Date imgDate; 
    
    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getImgDesp() {
        return imgDesp;
    }

    public void setImgDesp(String imgDesp) {
        this.imgDesp = imgDesp == null ? null : imgDesp.trim();
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgThumbUrl() {
        return imgThumbUrl;
    }

    public void setImgThumbUrl(String imgThumbUrl) {
        this.imgThumbUrl = imgThumbUrl == null ? null : imgThumbUrl.trim();
    }

    public Date getImgDate() {
        return imgDate;
    }

    public void setImgDate(Date imgDate) {
        this.imgDate = imgDate;
    }
}