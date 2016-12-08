
package com.maven01.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.maven01.web.bean.Resource;
import com.maven01.web.bean.User;
import org.apache.log4j.Logger; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml","classpath:spring-mybatis.xml" })
public class TestUserService 
{

	private static final Logger logger = Logger.getLogger(TestUserService.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceService resourceService;
	
	
	@Test
	public void testGetLeftMenu()
	{
		try {
			Collection<Resource> test=resourceService.getUserMenuResourceList(1);
			logger.debug("输出："+test.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testResource() 
//	{
//		List<Resource> resourceList=new ArrayList<Resource>();
//		try {
//			resourceList=resourceService.getUserResourceList(1);
//			logger.debug(resourceList);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testQueryById() 
	{
		//User userInfo = userService.getUserById(1);
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
