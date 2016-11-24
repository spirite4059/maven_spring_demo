package com.maven01.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maven01.web.bean.Article;
import com.maven01.web.dao.ArticleDao;
import com.maven01.web.dao.BaseDao;
import com.maven01.web.service.ArticleService;


@Service
public class ArticleServiceImp extends BaseServiceImp<Article> implements ArticleService 
{
	@Autowired
	private ArticleDao articleDao;
	
	@Override  //上面是baseDao里面，抽象类，必须实现其他的直接继承了
	protected BaseDao<Article> getDao()
	{
		return articleDao;
	}
	
	//保存某个实体类
	public int insertAndGetId(Article article) throws Exception
	{
		return articleDao.insertAndGetId(article);
	}
	
}
