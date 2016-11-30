package com.maven01.web.service;

import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.PageInfoM;

public interface ArticleBlockService extends BaseService<ArticleBlock>
{
	
	//插入列表，根据插入的位置，向里面插入
	public void insertBlock(int index,ArticleBlock articleBlock) throws Exception; 
	
	//删除某些块
	public void deleteBlock(int blockId,int articleId) throws Exception;
	
	//选择块块
	public PageInfoM<ArticleBlock> selectBlock(int page,int rows,int articleId)throws Exception;
	
}
