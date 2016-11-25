package com.maven01.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticlePost;
import com.maven01.web.service.ArticlePostService;
import com.maven01.web.service.ArticleService;


@Controller
@RequestMapping("/Article")
public class ArticleController extends BaseController
{
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/queryList")
	@ResponseBody	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfo queryList(Integer page,Integer rows)
	{
		//获得固定的数据
		logger.info(page+":"+rows);	//给些初始的数值		
		PageInfo<Article> pageInfo = new PageInfo<Article>(null); 
		
		try
		{
			PageHelper.startPage(page, rows);
			List<Article> list = articleService.getList();
			pageInfo = new PageInfo<Article>(list);  
		}
		catch(Exception e)
		{
			logger.info(e.toString());
		}
		
		return pageInfo;  //返回的是对象列表 
	}
	
	
	@RequestMapping ("/save")
	@ResponseBody
	public Map<String,Object> save(Article article)
	{
		Map<String,Object>result=this.success(null);
		
		try
		{
			articleService.save(article);
		}catch(Exception e)
		{
			result=this.error(e.getMessage());//把错误信息输出去
		}
		return result; 
	}
	
	@RequestMapping ("/insertAndGetId")
	@ResponseBody
	public Map<String,Object> insertAndGetId (@RequestBody Article article)
	{
		Map<String,Object>result;

		try{
			Article a=new Article();
			a.setArticleName(article.getArticleName());
			a.setArticleList(article.getArticleList());
			
			//logger.debug("输入的id"+a.getArticleId().toString());
			//System.out.println("输入sdf的id:"+a.getArticleId().toString());
			//在返回的时候会直接放到输入的文章上去
			articleService.insertAndGetId(a);
			
			//logger.info("输出的id"+a.getArticleId().toString());
			
			Map<String,Object> input_data=new HashMap<String, Object>();
			input_data.put("key",a.getArticleId());
			result=this.success(input_data);
		}catch(Exception e)
		{
			Map<String,Object> input_data=new HashMap<String, Object>();
			result=this.error(e.getMessage());
		}
		return result; 
	}

	
	@RequestMapping("/update")	//根据情况更新
	@ResponseBody
	public Map<String,Object> update(@RequestBody Article article)
	{
		//logger.info(article.toString());
		
		Map<String,Object> result = this.success(null);
		try{
			articleService.update(article);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")	//根据情况更新
	@ResponseBody
	public Map<String,Object> delete(int id)
	{
		Map<String,Object> result = this.success(null);
		try{
			articleService.deleteById(id);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
}
