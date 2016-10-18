package com.maven01.web.dao;

import java.util.List;
import java.util.Set;
import com.maven01.web.bean.Permission;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.User;

public interface RoleMapper 
{
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //根据角色的id查找权限
	List<Permission> findPermissionByRoleId(Integer role_id);  
	
}


