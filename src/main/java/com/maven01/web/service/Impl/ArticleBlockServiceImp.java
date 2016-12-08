package com.maven01.web.service.Impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.PageInfoM;
import com.maven01.web.dao.ArticleBlockDao;
import com.maven01.web.dao.ArticleDao;
import com.maven01.web.dao.ArticlePostDao;
import com.maven01.web.dao.BaseDao;
import com.maven01.web.service.ArticleBlockService;
import com.maven01.web.util.util;

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
	
	
	//选择文章块列表,有为空的可能 
	public PageInfoM<ArticleBlock> selectBlock(int page,int rows,int articleId)throws Exception
	{	
		Article article= articleDao.getEntityById(articleId);
		if(article == null) 
			throw new Exception("没选择有效的文章");
		
		 
		//获取article list用#区分,第一个#去掉 
		String blockListStr = article.getArticleList();
		List<Integer> blockLink = new LinkedList<Integer>();		
		
		
		//字符串是空的,
		if(blockListStr!=null && !blockListStr.equals(""))
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
			if(blockLink.size()<=0) return null;	//throw new Exception("");
			
			//根据mybatis的pageInfor来定义来定义的基础类
			int total = blockLink.size();
			int left =	total%rows;
			int pages  =	(int) Math.floor(total/rows);
			
			if(left!=0)pages++;	//如果分页正好
			
			if(page<=0)
				page=1;
			else if(page>pages)
				page=pages;
			
			int pageSize=rows;
			int pageNum=page;
			
			//算一下本页文件的范围
			int startRow;
			int endRow;
			
			startRow=(pageNum-1)*pageSize+1;
			endRow=startRow+pageSize-1; 	//1+10-1=10，范围是1-10
			
			if(endRow>total)endRow=total;	//例子：1-10是第一个页面，9
			
			int size=endRow-startRow+1;		//总共的数量
			int firstPage = 1 ;
			int lastPage  = pages;
			
			int prePage	 =  pageNum-1;
			int nextPage =  pageNum+1;
			if(nextPage>lastPage)nextPage=lastPage;
			
			boolean isFirstPage	=false;
			boolean isLastPage	=false;
			if(page==firstPage) isFirstPage	=true;
			if(page==lastPage)  isLastPage	=true;
			
			//暂时不知道干嘛用
			int navigatePages=8;		//导航页码数
			int naviagetPageNums=1;		//所有导航页号
			
			//把所有相关的页面选择出来
			List <ArticleBlock> data = articleBlockDao.selectBlockByList(blockLink);   
			
//			for(ArticleBlock element : data)
//			{
//				logger.info(element.getBlockId().toString());
//			}
			
			//将数值设置到里面并返回
			PageInfoM<ArticleBlock> pageInfoM =new PageInfoM<ArticleBlock>();
			pageInfoM.setPageNum(pageNum);
			pageInfoM.setPageSize(pageSize);
			pageInfoM.setSize(size);
			pageInfoM.setStartRow(startRow);
			pageInfoM.setEndRow(endRow);
			pageInfoM.setTotal(total);
			pageInfoM.setPages(pages);
			pageInfoM.setFirstPage(firstPage);
			pageInfoM.setLastPage(lastPage);
			pageInfoM.setPrePage(prePage);
			pageInfoM.setNextPage(nextPage);
			pageInfoM.setIsFirstPage(isFirstPage);
			pageInfoM.setIsLastPage(isLastPage);
			pageInfoM.setList(data);
			
			return pageInfoM;
		}else return null;
	}
	
	
	//插入列表
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void insertBlock(int inputIndex,ArticleBlock block1) throws Exception
	{	
		
//		ArticleBlock block1=new ArticleBlock();
//		block1.setBlockId(-1);
//		block1.setBlockContent("");
//		block1.setArticleId(48);
//		block1.setBlockType(0);		//文章块是文字
//		block1.setDate(util.getNowDate());
		
		
		int articleId  = block1.getArticleId();   
		Article article1=new Article();
		article1.setArticleId(48);
		
		List<Article> articles= articleDao.getListByEntity(article1); 
		if(articles.size()>0)
			article1=articles.get(0);
		else   
			throw new Exception("没选择有效的文章");
		
		//logger.debug("之前id:"+block1.getBlockId());
		//当前的articleBlock块,保存并返回id数值
		articleBlockDao.insertAndGetId(block1);
	    int current_id = block1.getBlockId();	//插入后返回正确的数值
		//logger.debug("获得id:"+block1.getBlockId());
		 
		//获取article list用#区分,第一个#去掉 
		String blockListStr = article1.getArticleList();
		
		//采用指针方式的	
		List<Integer> blockLink = new LinkedList<Integer>();		
		
		
		//字符串是空的
		if(blockListStr!=null && !blockListStr.equals(""))
		{
			//肯定是没有负数的,负数
			if(inputIndex ==-1)
			{
				//直接将输入插入到最后面
				blockListStr+="#"+current_id;
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
				List<Integer> link = new LinkedList<Integer>();	
				
				//循环,找到插入的位置,插入到最后面
				for(int i=0;i<blockLink.size();i++)
				{
					if(blockLink.get(i)== inputIndex )
					{
						blockLink.add(i+1, current_id);
						is_find=true;
						break;
					}
				}
				
				if(is_find == false) blockLink.add(current_id);	//插入到最后面了
				
				
				//数值转成字符串，然后输出
				blockListStr="";
				for(Integer blockIndex:blockLink)
				{
					blockListStr+="#"+blockIndex;
				}
			}
		}else	//如果之前就是空的，放到字符串的最后
		{
			blockListStr = "#"+ current_id ;
		}
		article1.setArticleList(blockListStr);
		articleDao.update(article1);		//更新文章的内容
		
	}//插入文章块
	

	
	
	public void deleteBlock(int blockId,int articleId) throws Exception
	{
		//int block_id=11;	//要删除的block块
		//int article_id=48;
		
		Article article= articleDao.getEntityById(articleId);
		if(article == null) throw new Exception("没选择有效的文章");
		
		 
		//获取article list用#区分,第一个#去掉 
		String blockListStr = article.getArticleList();
		List<Integer> blockLink = new LinkedList<Integer>();		
		
		
		//字符串是空的,
		if(blockListStr!=null && !blockListStr.equals(""))
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
			
			if(blockLink.size()<=0) throw new Exception("文章没有有效文章块");
			
			boolean is_find=false;
			for(Integer elem:blockLink)
			{
				//这块是可以直接删除的
				if(elem==blockId) 
				{
					blockLink.remove(elem);
					is_find=true;
					break;
				}
			} 
			
			if(is_find)	 //如果找到了的话 
			{
				//数值转成字符串，然后输出
				blockListStr="";
				for(Integer elem:blockLink)	
				{
					blockListStr+="#"+elem;			//把一块一块拼成一个整体
				}
				
				//更新到数据库里面去
				//是之前已经选择出的数据
				article.setArticleList(blockListStr);
				articleDao.update(article);
			
				//删除文章块
				articleBlockDao.deleteById(blockId);	
				
			}else throw new Exception("没有可删除的文章块");	
		}
	}
} 	








