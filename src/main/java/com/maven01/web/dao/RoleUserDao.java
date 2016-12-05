package com.maven01.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.maven01.web.bean.RoleUser;


// @描述     角色用户数据库交互层
public interface RoleUserDao  extends BaseDao<RoleUser>
{   
	//根据roleId查询 角色资源表   
	public List<RoleUser> getListByRoleId(@Param("roleId") int roleId);
}




