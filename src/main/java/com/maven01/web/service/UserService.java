package com.maven01.web.service;

import java.util.List;

import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.User;


public interface UserService extends BaseService<User>
{
	/**
	 * 校验用户名唯一性
	 * @param id
	 * @param userName
	 * @return
	 */
	User getUserByUserName(int id, String userName);
    
	
	/**
	 * 根据用户名获取当前登录用户
	 * @param userName  ??为什么只有一个用户
	 * @return
	 */
	public User getLoginUser(String userName);

	
}