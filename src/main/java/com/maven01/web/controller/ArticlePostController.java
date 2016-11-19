package com.maven01.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven01.web.bean.ArticlePost;
import com.maven01.web.service.ArticlePostService;

@Controller
@RequestMapping("/ArticlePost")
public class ArticlePostController extends BaseController
{
	@Autowired
	private ArticlePostService articleService;
	
	@RequestMapping("/queryList")
	@ResponseBody
	public PageInfo queryList(int page,int rows,ArticlePost articlePost)
	{
		//获得固定的数据
		
	}
	
}
