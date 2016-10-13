package com.maven01.web.service.Impl;

import java.util.List;
import com.maven01.web.dao.UserMapper;
import com.maven01.web.bean.User;
import com.maven01.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService") 
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(int id) 
	{
		
		return userMapper.selectByPrimaryKey(id);
		//return null;
	}
}





