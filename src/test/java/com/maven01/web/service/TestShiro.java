
package com.maven01.web.service;

import java.util.List;
import com.maven01.web.bean.User;
import org.apache.log4j.Logger; 
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.util.ThreadState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml",
									"classpath:spring-mybatis.xml",
									"classpath:test-shiro.xml"})
									
//@ActiveProfiles（"dev"）

public class TestShiro 
{

	public Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	private static ThreadState subjectThreadState;	//用户案例的线程



    
    
}
