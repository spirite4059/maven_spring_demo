package com.maven01.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven01.web.bean.ArticlePost;
import com.maven01.web.dao.ArticlePostDao;
import com.maven01.web.dao.BaseDao;
import com.maven01.web.service.ArticlePostService;


@Service
public class ArticlePostServiceImp extends BaseServiceImp<ArticlePost> implements ArticlePostService
{
	@Autowired
	private ArticlePostDao articlePostDao;
	
	@Override  //上面是baseDao里面，抽象类，必须实现其他的直接继承了
	protected BaseDao<ArticlePost> getDao()
	{
		return articlePostDao;
	}
}
