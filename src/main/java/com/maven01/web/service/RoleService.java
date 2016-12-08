package com.maven01.web.service;

import java.util.List;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.RoleResource;
import com.maven01.web.bean.User;

public interface RoleService extends BaseService<Role> 
{

	//根据角色id查询角色所拥有的资源
	public List<RoleResource> getSelectedResourceByRoleId(int roleId)throws Exception;
	
	//根据角色id查询角色所拥有的用户
	public List<User> getSelectedUserByRoleId(int roleId)throws Exception;
	
	//保存分配的资源
	public void insertRoleResource(String resourceIds,int roleId)throws Exception;
	
	//保存分配的用户
    public void insertRoleUser(String userIds,int roleId)throws Exception;

}



