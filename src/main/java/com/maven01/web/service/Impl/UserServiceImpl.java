package com.maven01.web.service.Impl;

import java.util.List;

import com.maven01.web.dao.BaseDao;
import com.maven01.web.dao.UserMapper;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.User;
import com.maven01.web.service.ArticleBlockService;
import com.maven01.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImp <User> implements UserService
{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(int id) 
	{
		
		return userMapper.selectByPrimaryKey(id);
		//return null;
	}

	@Override
	protected BaseDao<User> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
}





