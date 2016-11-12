package com.maven01.web.service;

import java.util.List;
import java.util.Set;
import com.maven01.web.bean.*;


public interface UserService 
{
	
	//选择一些用户信息
	User getUserById(int id);
	User findUserByUsername(String username);
	public List<Role> findRolesByUser(String username);
	public List<Permission> findPermissionByRoleId(int role_id);
	
}