package com.maven01.web.service;

import com.maven01.web.bean.Article;


public interface ArticleService extends BaseService<Article> 
{
	//保存某个实体类
	public int insertAndGetId(Article article) throws Exception;
}
