
package com.maven01.web.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.maven01.web.bean.Permission;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.User;
import org.apache.log4j.Logger; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml",
									"classpath:spring-mybatis.xml" }
					 )
public class TestUserService 
{

	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
	
	
	@Autowired
	private UserService userService;
	
	
//	@Test
//	public void testQueryById() 
//	{
//		User userInfo = userService.getUserById(1);
//		LOGGER.info("选择出来的是什么啊："+JSON.toJSON(userInfo));
//	}
	
	
	@Test
	public void testQueryAll() 
	{
		//直接查找
		List<Role> roles_set = userService.findRolesByUser("conan");
		List<Permission> per_list = new ArrayList<Permission>();
		
		
	    //角色集合
	    Set<String> roles = new HashSet<String>();
	    Set<String> permissions = new HashSet<String>();  
	    
	    int i,j,role_id;
	    
	    for(i = 0; i < roles_set.size(); i++)  
        {  
	    	roles.add(roles_set.get(i).getRolename());
	    	role_id=(roles_set.get(i).getId());
	    	
	    	per_list=userService.findPermissionByRoleId(role_id); 		//每个权限放到数组里面
		    for(j = 0; j < per_list.size(); j++)  
	        {  
		    	permissions.add(per_list.get(j).getPermissionname());
	        } 	    	
        } 
	    
	    LOGGER.info("出出出:"+roles);
	    LOGGER.info("出出出:"+permissions);
	}
}
	    	
