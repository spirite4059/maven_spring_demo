package com.maven01.web.service;

import java.util.List;

import com.maven01.web.bean.ArticleBlock;
import com.maven01.web.bean.User;


public interface UserService extends BaseService<User>
{
	public User getUserById(int id);
	
}