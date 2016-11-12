
package com.maven01.web.service;

import java.util.List;
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

	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void testQueryById() 
	{
		User userInfo = userService.getUserById(1);
		LOGGER.info("选择出来的是什么啊："+JSON.toJSON(userInfo));
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
