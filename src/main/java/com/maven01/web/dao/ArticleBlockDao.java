package com.maven01.web.dao;

import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.ArticlePost;
import java.util.List;
import org.apache.ibatis.annotations.Param;


//操作文章块的控制器
public interface ArticleBlockDao extends BaseDao<ArticleBlock>
{
	//保存某个文章的一个块
	public int insertAndGetId(ArticleBlock articleBlock) throws Exception;
	
	//根据输入的block list选择出数据
	public List<ArticleBlock> selectBlockByList(List blockList) throws Exception; 
	
}