package com.maven01.web.service.Impl;

import java.util.List;

import com.maven01.web.dao.BaseDao;
import com.maven01.web.dao.UserDao;
import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.User;
import com.maven01.web.service.ArticleBlockService;
import com.maven01.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends BaseServiceImp <User> implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDao<User> getDao() {
		return userDao;
	}
	
	/**
	 * 校验用户名唯一性
	 */
	public User getUserByUserName(int id, String userName)
	{
		User user=new User();
		user.setId(id);
		user.setUsername(userName);
		
		return userDao.getUserByUserName(user);
	}
    
	
	/**
	 * 根据用户名获取当前登录用户
	 * @param userName  ??为什么只有一个用户
	 */
	public User getLoginUser(String userName)
	{
		return userDao.getLoginUser(userName);
	}
}





