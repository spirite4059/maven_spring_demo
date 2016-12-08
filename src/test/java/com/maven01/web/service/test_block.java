package com.maven01.web.service;

import java.util.LinkedList;
import java.util.List;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.pagehelper.PageInfo;
import com.maven01.web.bean.Article;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.PageInfoM;
import com.maven01.web.dao.ArticleBlockDao;
import com.maven01.web.dao.ArticleDao;
import com.maven01.web.util.util;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml","classpath:spring-mybatis.xml" })

public class test_block 
{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArticleBlockDao articleBlockDao;		//文章块的数据操作类
	
	@Autowired
	private ArticleDao articleDao;					//文章的数据操作类
	
	
	@Autowired
	private ArticleBlockService articleBlockService;		//文章块的数据操作类
	
	@Test
	public void insertBlock() throws Exception
	{	
		ArticleBlock block1=new ArticleBlock();
		block1.setBlockContent("");
		block1.setArticleId(48);
		block1.setBlockType(0);		//文章块是文字
		block1.setDate(util.getNowDate());
		
		//插入
		articleBlockService.insertBlock(4, block1);
	}
	
	
//	@Test
//	public void insertBlock() throws Exception
//	{	
//		ArticleBlock block1=new ArticleBlock();
//		block1.setBlockContent("");
//		block1.setArticleId(48);
//		block1.setBlockType(0);		//文章块是文字
//		
//		int inputIndex = 10;	//block的位置，第一次就插入-1
//		int articleId  = block1.getArticleId();
//		
//		Article article1=new Article();
//		article1.setArticleId(48);
//		
//		List<Article> articles= articleDao.getListByEntity(article1); 
//		if(articles.size()>0)
//			article1=articles.get(0);
//		else   
//			throw new Exception("没选择有效的文章");
//		
//		
//		//当前的articleBlock块,保存并返回id数值
//		 articleBlockDao.insertAndGetId(block1);
//		 int current_id = block1.getBlockId();	//插入后返回正确的数值
//		
//		 
//		//获取article list用#区分,第一个#去掉 
//		String blockListStr = article1.getArticleList();
//		
//		//采用指针方式的	
//		List<Integer> blockLink = new LinkedList<Integer>();		
//		
//		
//		//字符串是空的
//		if(blockListStr!=null && !blockListStr.equals(""))
//		{
//			//肯定是没有负数的,负数
//			if(inputIndex ==-1)
//			{
//				//直接将输入插入到最后面
//				blockListStr+="#"+current_id;
//			}else
//			{
//				//用#!来切分字符串
//				String[] tmp_array=blockListStr.split("#");
//				for(int i=0;i<tmp_array.length;i++)	
//				{
//					if(!tmp_array[i].equals(""))
//					{
//						blockLink.add( Integer.valueOf(tmp_array[i]));
//					}
//				}
//				
//				Boolean is_find=false;
//				List<Integer> link = new LinkedList<Integer>();	
//				
//				//循环,找到插入的位置,插入到最后面
//				for(int i=0;i<blockLink.size();i++)
//				{
//					if(blockLink.get(i)== inputIndex )
//					{
//						blockLink.add(i+1, current_id);
//						is_find=true;
//						break;
//					}
//				}
//				
//				if(is_find == false) blockLink.add(current_id);	//插入到最后面了
//				
//				
//				//数值转成字符串，然后输出
//				blockListStr="";
//				for(Integer blockIndex:blockLink)
//				{
//					blockListStr+="#"+blockIndex;
//				}
//			}
//		}else	//如果之前就是空的，放到字符串的最后
//		{
//			blockListStr = "#"+ current_id ;
//		}
//		
//		article1.setArticleList(blockListStr);
//		//更新文章的内容
//		articleDao.update(article1);
//		
//	}	//插入文章块  
	
	
	
	//处理分页的事情而已
//	@Test
//	public void list_all() throws Exception
//	{
//		//自己解决分页的问题
//		// page 和 rows,一个是当前的页数，一个是每个页面有多少个
//		
//		//做两步操作，一步选择出article相应的list,解析,然后做处理;然后算计当前的
//		
//		int page=1;
//		int rows=10;
//		int article_id=48;
//		
//		Article article= articleDao.getEntityById(article_id);
//		if(article == null) 
//			throw new Exception("没选择有效的文章");
//		
//		 
//		//获取article list用#区分,第一个#去掉 
//		String blockListStr = article.getArticleList();
//		List<Integer> blockLink = new LinkedList<Integer>();		
//		
//		
//		//字符串是空的,
//		if(blockListStr!=null && !blockListStr.equals(""))
//		{
//			//用#!来切分字符串
//			String[] tmp_array=blockListStr.split("#");
//			for(int i=0;i<tmp_array.length;i++)	
//			{
//				if(!tmp_array[i].equals(""))
//				{
//					blockLink.add( Integer.valueOf(tmp_array[i]));
//				}
//			}
//			if(blockLink.size()<=0) return;//throw new Exception("没内容");
//			
//			//根据mybatis的pageInfor来定义来定义的基础类
//			int total = blockLink.size();
//			int left =	total%page;
//			int pages  =	(int) Math.floor(total/page);
//			
//			if(left!=0)pages++;	//如果分页正好
//			
//			if(page<=0)
//				page=1;
//			else if(page>pages)
//				page=pages;
//			
//			int pageSize=rows;
//			int pageNum=page;
//			
//			//算一下本页文件的范围
//			int startRow;
//			int endRow;
//			
//			startRow=(pageNum-1)*pageSize+1;
//			endRow=startRow+pageSize-1; 	//1+10-1=10，范围是1-10
//			
//			if(endRow>total)endRow=total;	//例子：1-10是第一个页面，9
//			
//			int size=endRow-startRow+1;		//总共的数量
//			int firstPage = 1 ;
//			int lastPage  = pages;
//			
//			int prePage	 =  pageNum-1;
//			int nextPage =  pageNum+1;
//			if(nextPage>lastPage)nextPage=lastPage;
//			
//			boolean isFirstPage	=false;
//			boolean isLastPage	=false;
//			if(page==firstPage) isFirstPage	=true;
//			if(page==lastPage)  isLastPage	=true;
//			
//			//暂时不知道干嘛用
//			int navigatePages=8;		//导航页码数
//			int naviagetPageNums=1;		//所有导航页号
//			
//			//把所有相关的页面选择出来
//			List <ArticleBlock> data = articleBlockDao.selectBlockByList(blockLink);   
//			
////			for(ArticleBlock element : data)
////			{
////				logger.info(element.getBlockId().toString());
////			}
//			
//			//将数值设置到里面并返回
//			PageInfoM<ArticleBlock> pageInfoM =new PageInfoM<ArticleBlock>();
//			pageInfoM.setPageNum(pageNum);
//			pageInfoM.setPageSize(pageSize);
//			pageInfoM.setSize(size);
//			pageInfoM.setStartRow(startRow);
//			pageInfoM.setEndRow(endRow);
//			pageInfoM.setTotal(total);
//			pageInfoM.setPages(pages);
//			pageInfoM.setFirstPage(firstPage);
//			pageInfoM.setLastPage(lastPage);
//			pageInfoM.setPrePage(prePage);
//			pageInfoM.setNextPage(nextPage);
//			pageInfoM.setIsFirstPage(isFirstPage);
//			pageInfoM.setIsLastPage(isLastPage);
//			pageInfoM.setList(data);
//			
//		}
//	}


	//删除某一个block块
//	@Test
//	public void deleteBlock() throws Exception
//	{
//		int block_id=13;	//要删除的block块
//		int article_id=48;
//		
//		Article article= articleDao.getEntityById(article_id);
//		if(article == null) throw new Exception("没选择有效的文章");
//		
//		 
//		//获取article list用#区分,第一个#去掉 
//		String blockListStr = article.getArticleList();
//		List<Integer> blockLink = new LinkedList<Integer>();		
//		
//		
//		//字符串是空的,
//		if(blockListStr!=null && !blockListStr.equals(""))
//		{
//			//用#!来切分字符串
//			String[] tmp_array=blockListStr.split("#");
//			for(int i=0;i<tmp_array.length;i++)	
//			{
//				if(!tmp_array[i].equals(""))
//				{
//					blockLink.add( Integer.valueOf(tmp_array[i]));
//				}
//			}
//			
//			if(blockLink.size()<=0) throw new Exception("文章没有有效文章块");
//			
//			boolean is_find=false;
//			for(Integer elem:blockLink)
//			{
//				//这块是可以直接删除的
//				if(elem==block_id) 
//				{
//					blockLink.remove(elem);
//					is_find=true;
//					break;
//				}
//			} 
//			
//			if(is_find)	 //如果找到了的话 
//			{
//				//数值转成字符串，然后输出
//				blockListStr="";
//				for(Integer elem:blockLink)	
//				{
//					blockListStr+="#"+elem;			//把一块一块拼成一个整体
//				}
//				
//				//更新到数据库里面去
//				//是之前已经选择出的数据
//				article.setArticleList(blockListStr);
//				articleDao.update(article);
//				
//				
//				//删除文章块
//				articleBlockDao.deleteById(block_id);	
//				
//			}else throw new Exception("没有可删除的文章块");	
//		}
//	}
}
