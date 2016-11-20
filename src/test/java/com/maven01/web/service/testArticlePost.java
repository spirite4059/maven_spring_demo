package com.maven01.web.service;
import java.util.ArrayList;
import java.util.List;

import com.maven01.web.bean.ArticlePost;
import com.maven01.web.bean.UpImage;
import com.maven01.web.bean.User;
import com.maven01.web.util.util;

import org.apache.log4j.Logger; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml","classpath:spring-mybatis.xml" })
public class testArticlePost {
	
	private static final Logger LOGGER = Logger.getLogger(test_image.class);
	
	@Autowired
	private ArticlePostService Service;
	
	
	@Test
	public void testGetList() 
	{
       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
		List<ArticlePost> posts=new ArrayList<ArticlePost>();
		try {
			posts=Service.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("选择出来的是什么啊："+posts);
	}

}
