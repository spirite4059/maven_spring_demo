package com.maven01.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.maven01.web.bean.RoleResource;


public interface RoleResourceDao  extends BaseDao <RoleResource>
{
    // 根据roleId查询 角色资源表
	public List<RoleResource> getListByRoleId(@Param("roleId") int roleId);

}
