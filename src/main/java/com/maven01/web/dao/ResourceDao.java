package com.maven01.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maven01.web.bean.Resource;

public interface ResourceDao  extends BaseDao<Resource> 
{
	/**
	 * 资源管理 json 集合
	 */
	public List<Resource> getTreeList(@Param("parentId") int parentId) throws Exception;
    
	
	/**
	 * 根据角色id查询角色所拥有的资源
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getSelectedResourceByRoleId(@Param("roleId") int roleId)throws Exception;
	
	
	/**
	 * 根据登录人的id查询所拥有的资源信息 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getUserResourceList(@Param("userId") int userId)throws Exception;
	
	
	/**
	 * 根据登录人的id查询所拥有的左侧菜单信息
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Resource> getUserMenuResourceList(@Param("userId") int userId)throws Exception;
	
	
}