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
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.PageInfoM;
import com.maven01.web.service.ArticleBlockService;
import com.maven01.web.service.ArticleService;


@Controller
@RequestMapping("/ArticleBlock")
public class ArticleBlockController extends BaseController
{
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleBlockService articleBlockService;
	
	
	@RequestMapping("/queryList")
	@ResponseBody	//page代表当前是第几页，rows代表每个页面显示多少数据
	public PageInfoM<ArticleBlock> selectBlock(Integer page,Integer rows,Integer articleId)
	{
		//获得固定的数据
		logger.info(page+":"+rows);	//给些初始的数值		
		
		PageInfoM<ArticleBlock> articleBlocks= null;
		
		try
		{
			articleBlocks = articleBlockService.selectBlock(page, rows, articleId);  
		}
		catch(Exception e)
		{
			logger.info(e.toString());
		}
		
		return articleBlocks;  //返回的是对象列表 
	}
	
	
	@RequestMapping ("/insert")
	@ResponseBody
	public Map<String,Object> insertBlock(Integer index,ArticleBlock articleBlock)
	{
		Map<String,Object>result=this.success(null);
		
		try
		{
			articleBlockService.insertBlock(index,articleBlock);
		}catch(Exception e)
		{
			result=this.error(e.getMessage());//把错误信息输出去
		}
		return result; 
	}
	

	
	@RequestMapping("/update")	//根据情况更新文章块
	@ResponseBody
	public Map<String,Object> update(@RequestBody ArticleBlock articleBlock)
	{
		//logger.info(article.toString());
		Map<String,Object> result = this.success(null);
		try{
			articleBlockService.update(articleBlock);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")	//根据情况更新
	@ResponseBody
	public Map<String,Object> delete(Integer blockId,Integer articleId)
	{
		Map<String,Object> result = this.success(null);
		try{
			articleBlockService.deleteBlock(blockId,articleId);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
}











