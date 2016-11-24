package com.maven01.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven01.web.bean.ArticlePost;
import com.maven01.web.service.ArticlePostService;



@Controller
@RequestMapping("/ArticlePost")
public class ArticlePostController extends BaseController
{
	
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticlePostService articlePostService;
	
	@RequestMapping("/queryList")
	@ResponseBody
	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfo queryList(Integer page,Integer rows) throws Exception
	{
		//获得固定的数据
		logger.debug(page+":"+rows);	//给些初始的数值
		if(page==null) page=1;
		if(rows==null) rows=10;
		
		PageHelper.startPage(page, rows);
		List<ArticlePost> list = articlePostService.getList();
		PageInfo<ArticlePost> pageInfo = new PageInfo<ArticlePost>(list);
		return pageInfo;  //返回的是对象列表 
	}
	
	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfo insert(Integer page,Integer rows) throws Exception
	{
		//获得固定的数据
		logger.debug(page+":"+rows);	//给些初始的数值
		if(page==null) page=1;
		if(rows==null) rows=10;
		
		PageHelper.startPage(page, rows);
		List<ArticlePost> list = articlePostService.getList();
		PageInfo<ArticlePost> pageInfo = new PageInfo<ArticlePost>(list);
		return pageInfo;  //返回的是对象列表 
	}
}





