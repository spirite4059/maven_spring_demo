package com.maven01.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.maven01.web.bean.User;

public interface UserDao extends BaseDao<User>
{
	/**
	 * 校验用户名唯一性
	 * @param user		*/
	User getUserByUserName(User user);
	
	/**
	 * 根据用户名获取当前登录用户
	 * @param userName	*/
	public User getLoginUser(@Param("userName") String userName);
	
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId	*/
	public List<User> getUsers()throws Exception;

}



