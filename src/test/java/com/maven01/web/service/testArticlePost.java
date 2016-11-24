package com.maven01.web.service;
import java.util.ArrayList;
import java.util.List;

import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticlePost;
import com.maven01.web.bean.UpImage;
import com.maven01.web.bean.User;
import com.maven01.web.util.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml","classpath:spring-mybatis.xml" })
public class testArticlePost {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticlePostService service;
	
	
	@Test
	public void getList() 
	{
       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
		List<ArticlePost> posts=new ArrayList<ArticlePost>();
		try {
			posts=service.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("选择出来的是什么啊："+posts);
	}
	
//	@Test
//	public void getListByEntity() 
//	{
////       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
////		List<ArticlePost> posts=new ArrayList<ArticlePost>();
////		try {
////			posts=service.getList();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		logger.info("选择出来的是什么啊："+posts);
//	}
//
//	
//	@Test
//	public void  insert() throws Exception
//	{
//		ArticlePost a=new ArticlePost();
//		a.setPostNum(3);
//		a.setPostType(0);
//		a.setPostContent("adsfasdf");
//		
//		service.save(a);
//	}
//	
//	
//	@Test
//	public void  update() throws Exception
//	{
//		ArticlePost a=new ArticlePost();
//		a.setPostId(1);
//		a.setPostNum(3);
//		a.setPostType(0);
//		a.setPostContent("adsfasdf");
//		
//		service.update(a);
//	}
//	
//	
//	@Test
//	public void  delete() throws Exception
//	{
//		service.deleteById(2);
//	}
//	

}
