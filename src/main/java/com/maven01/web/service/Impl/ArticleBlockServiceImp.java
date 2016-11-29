package com.maven01.web.service.Impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.dao.ArticleBlockDao;
import com.maven01.web.dao.ArticleDao;
import com.maven01.web.dao.ArticlePostDao;
import com.maven01.web.dao.BaseDao;
import com.maven01.web.service.ArticleBlockService;

@Service
public class ArticleBlockServiceImp extends BaseServiceImp <ArticleBlock> implements ArticleBlockService
{
	@Autowired
	private ArticleBlockDao articleBlockDao;	//文章块的数据操作类
	
	@Autowired
	private ArticleDao articleDao;				//文章的数据操作类
	
	
	@Override
	protected BaseDao<ArticleBlock> getDao() 
	{
		// TODO Auto-generated method stub
		return articleBlockDao;
	}
	
	
	//插入列表
	public void insertBlock(int inputIndex,ArticleBlock articleBlock) throws Exception
	{	
		//如果没有指明index或者是0的话，默认是插入在最后的位置上
		int articleId=articleBlock.getArticleId();
		Article article = articleDao.getEntityById(articleId);	
		
		//当前的articleBlock块,保存并返回id数值
		int current_id = articleBlockDao.insertAndGetId(articleBlock);	
		
		//获取article list用#区分,第一个#去掉
		String blockListStr = article.getArticleList();
		
		//采用指针方式的	
		List<Integer> blockLink = new LinkedList<Integer>();	
		
		//字符串是空的
		if(blockListStr!=null && !blockListStr.equals(""))
		{
			//肯定是没有负数的,负数
			if(inputIndex ==-1)
			{
				//直接将输入插入到最后面
				blockListStr+="#"+articleBlock.getBlockId().toString();
			}else
			{
				//用#!来切分字符串
				String[] tmp_array=blockListStr.split("#");
				for(int i=0;i<tmp_array.length;i++)	
				{
					if(!tmp_array[i].equals(""))
					{
						blockLink.add( Integer.valueOf(tmp_array[i]));
					}
				}
				
				Boolean is_find=false;
				//循环,找到插入的位置,插入到最后面
				for(Integer blockIndex:blockLink)
				{
					if( blockIndex == inputIndex )
					{
						//在指定的位置后面插入一个当前的元素
						blockLink.add(blockIndex, current_id);
					}else
						blockLink.add(blockIndex);
				}
				
				blockListStr="#";
				//将序列转换成字符串
				for(Integer blockIndex:blockLink)
				{
					blockListStr+="#"+blockIndex;
				}
			}
		}else	//如果之前就是空的，放到字符串的最后
		{
			blockListStr = "#"+ current_id ;
		}
	}//插入文章块
	
	
	//

} 	








