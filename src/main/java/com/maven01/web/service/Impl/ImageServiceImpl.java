package com.maven01.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven01.web.bean.UpImage;
import com.maven01.web.dao.UpImageMapper;
import com.maven01.web.service.ImageService;

@Service("ImageService") 
public class ImageServiceImpl implements ImageService 
{
	@Autowired
	private UpImageMapper upImageDao;
	
	//保存图片信息到数据库
	public void insert_img(UpImage img) throws Exception
	{
		upImageDao.insert(img);
	}

}
