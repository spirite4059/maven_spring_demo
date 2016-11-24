package com.maven01.web.service;

import java.util.ArrayList;
import java.util.List;
import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticlePost;
import com.maven01.web.bean.UpImage;
import com.maven01.web.bean.User;
import com.maven01.web.dao.ArticleDao;
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

//用来测试artilce的增删改查
public class testArticle {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleService service;
	
	@Autowired
	private ArticleDao dao;
	
	
	//@Test
//	public void insertAndGetId() throws Exception
//	{
//		Article a=new Article();
//		a.setArticleName("test");
//		a.setArticleList("");
//		
//		int key=service.insertAndGetId(a);
//		logger.info("插入的新数值是："+key);
//		
//		int getkey=dao.insertAndGetId(a);
//		logger.info("插入的新数值是："+a.getArticleId()+"|||"+getkey);
//
//	}
	
	@Test
	public void getList()  
	{
       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
		List<Article> posts=new ArrayList<Article>();
		try {
			posts=service.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("getList："+posts);
	}
	
//	//@Test
//	public void getListByEntity() 
//	{
//       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
//		List<Article> posts=new ArrayList<Article>();
//		
//		Article a=new Article();
//		a.setArticleId(1);
//		
//		try {
//			posts=service.getListByEntity(a);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//logger.info(posts.toString());
//	}
//
//	
//	//@Test  
//	public void save() throws Exception
//	{
//		Article a=new Article();
//		a.setArticleName("test");
//		a.setArticleList("");
//		
//		service.save(a);
//	}
//
//	
//	//@Test  
//	public void saveAll() throws Exception
//	{
//		List<Article> saveList   =new ArrayList<Article>();
//		
//		Article a = new Article();
//		a.setArticleName("test");
//		a.setArticleList("");
//		
//		Article b = new Article();
//		b.setArticleName("test");
//		b.setArticleList("");
//		
//		saveList.add(a);
//		saveList.add(b);
//		
//		service.saveAll(saveList);
//	}
//	
//	
//	//@Test
//	public void  update() throws Exception
//	{
//		Article a=new Article();
//		a.setArticleId(1);
//		a.setArticleName("change");
//		a.setArticleList("123");
//		
//		service.update(a);
//	}
//	
//	
//	//@Test
//	public void delete() throws Exception
//	{
//		service.deleteById(6);
//	}
	
}
