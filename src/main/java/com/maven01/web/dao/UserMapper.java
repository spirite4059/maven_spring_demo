package com.maven01.web.dao;

import java.util.List;
import java.util.Set;

import com.maven01.web.bean.Permission;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.User;

public interface UserMapper 
{
	
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    
    User findUserByUsername(String userName);		//如果有两个怎么办呢？
    
	List<Role> findRolesByUser(String userName); 	//根据用户名查找角色
    //根据角色的id查找权限
	List<Permission> findPermissionByRoleId(Integer role_id);  
}







