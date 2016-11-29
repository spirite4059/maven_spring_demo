package com.maven01.web.dao;

import java.util.List;
import com.maven01.web.bean.Article;

public interface ArticleDao extends BaseDao<Article>
{
	//保存某个实体类
	public int insertAndGetId(Article article) throws Exception;
	
}