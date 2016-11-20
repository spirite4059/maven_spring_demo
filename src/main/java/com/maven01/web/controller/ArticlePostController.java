package com.maven01.web.controller;

import java.util.List;

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
	@Autowired
	private ArticlePostService articlePostService;
	
	@RequestMapping("/queryList")
	@ResponseBody
	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfo queryList(int page,int rows,ArticlePost articlePost) throws Exception
	{
		//获得固定的数据
		
		PageHelper.startPage(page, rows);
		List<ArticlePost> list = articlePostService.getList();
		PageInfo<ArticlePost> pageInfo = new PageInfo<ArticlePost>(list);
		return pageInfo;  //返回的是对象列表 
	}
}





