package com.maven01.web.dao;

import com.maven01.web.bean.UpImage;

public interface UpImageMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(UpImage record);

    int insertSelective(UpImage record);

    UpImage selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(UpImage record);

    int updateByPrimaryKey(UpImage record);
}