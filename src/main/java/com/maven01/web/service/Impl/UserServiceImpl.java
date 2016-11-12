package com.maven01.web.service.Impl;

import java.util.List;
import java.util.Set;

import com.maven01.web.dao.RoleMapper;
import com.maven01.web.dao.UserMapper;
import com.maven01.web.bean.Permission;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.User;
import com.maven01.web.service.UserService;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserMapper userMapper;
	private RoleMapper roleMapper;
	
	public Logger logger= Logger.getLogger(getClass());

	@Override
	public User getUserById(int id) 
	{
		
		return userMapper.selectByPrimaryKey(id);
		//return null;
	}
	
	@Override
	public User findUserByUsername(String userName)
	{
		return userMapper.findUserByUsername(userName);
	}
	
	@Override
	public List<Role> findRolesByUser(String username)
	{
		return userMapper.findRolesByUser(username);
	}
	
	@Override
	public List<Permission> findPermissionByRoleId(int role_id)
	{
		List<Permission> test=userMapper.findPermissionByRoleId(role_id);
		
		logger.info("返回:"+test);
		
		return test;
	}
}





