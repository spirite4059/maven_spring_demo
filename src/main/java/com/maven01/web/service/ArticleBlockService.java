package com.maven01.web.service;

import com.maven01.web.bean.ArticleBlock;

public interface ArticleBlockService extends BaseService<ArticleBlock>
{
	//取出id相应article的list字段
	//进行解析，放到到列表中
	//将操作的两个字段拿出来，
	
	
	//取列表，然后根据给的数据，拿出相应的block块
	//选择出相应的块，展示出来
	
	
	
	//插入列表，根据插入的位置，向里面插入
	public void insertBlock(int index,ArticleBlock articleBlock) throws Exception; 
	
	
}
