package com.maven01.web.service;


import com.maven01.web.bean.UpImage;
import com.maven01.web.util.util;

import org.apache.log4j.Logger; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml","classpath:spring-mybatis.xml" })
public class test_image {

	private static final Logger LOGGER = Logger.getLogger(test_image.class);
		
	@Autowired
	private ImageService Service;
	
	
	@Test
	public void testQueryById() 
	{
       // String web_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
        String web_path="\\img\\up_img\\";
        
        String time_str = util.refFormatNowDate();
        String img_str="img"+time_str;
        String thumb_str="thumb"+time_str;
        
		  //保存数据信息到数据库里面
  		UpImage img_bean=new UpImage();
  		img_bean.setImgName("test");
  		img_bean.setImgUrl(web_path+img_str);
  		img_bean.setImgType(0);
  		img_bean.setImgThumbUrl(web_path+thumb_str);
  		img_bean.setImgDate(util.getNowDate());
		
		try {
			Service.insert_img(img_bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//LOGGER.info("选择出来的是什么啊："+JSON.toJSON(userInfo));
	}
		
	//	@Test
	//	public void testQueryAll() {
	//	List<User> userInfos = userService.getUsers();
	//	LOGGER.info(JSON.toJSON(userInfos));
	//	}
	//	
	//	@Test
	//	public void testInsert() {
	//	User userInfo = new User();
	//	userInfo.setName("xiaoming");
	//	int result = userService.insert(userInfo);
	//	System.out.println(result);
	//	}
	//	

}
