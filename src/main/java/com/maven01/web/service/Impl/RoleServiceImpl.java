package com.maven01.web.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.RoleResource;
import com.maven01.web.bean.RoleUser;
import com.maven01.web.bean.User;
import com.maven01.web.dao.BaseDao;
import com.maven01.web.dao.RoleDao;
import com.maven01.web.dao.RoleResourceDao;
import com.maven01.web.dao.RoleUserDao;
import com.maven01.web.dao.UserDao;
import com.maven01.web.service.RoleService;

/**
 * 角色crup和资源角色相关比较
 */

@Service
public class RoleServiceImpl extends BaseServiceImp<Role> implements RoleService{

	@Autowired
	private RoleDao roleDao;  		
	
	@Autowired		
	private UserDao userDao;		
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private RoleUserDao roleUserDao;
	
	@Override
	protected BaseDao<Role> getDao() {
		return roleDao;
	}
	
	
	/**
	 * 根据角色id查询角色所拥有的资源
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<RoleResource> getSelectedResourceByRoleId(int roleId)throws Exception{
		List<RoleResource> list = roleResourceDao.getListByRoleId(roleId);
		return list;
	} 
	
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<User> getSelectedUserByRoleId(int roleId)throws Exception{
		List<User> users = userDao.getUsers();
		HashMap<Integer,User> userMap = new HashMap<Integer,User>();
		for (User user : users) {
			user.setRoleId(-1);//设置为-1
			userMap.put(user.getId(), user);
		}
		List<RoleUser> roleUserList = roleUserDao.getListByRoleId(roleId);
		for (RoleUser roleUser : roleUserList) {
			User user = userMap.get(roleUser.getUserId());
			if(null!=user){
				user.setRoleId(roleUser.getRoleId());
			}
		}
		return users;
	}
	
	
	/**
	 * 保存分配的资源
	 * @throws Exception
	 */
	public void insertRoleResource(String resourceIds,int roleId)throws Exception{
		RoleResource rr = new RoleResource();
    	rr.setRoleId(roleId);
    	roleResourceDao.deleteByEntity(rr);	
    	
    	List<RoleResource> roleResourceList = new ArrayList<RoleResource>();
    	String[] split = resourceIds.split(",");
    	for (String resourceId : split) {
    		RoleResource roleResource = new RoleResource();
    		roleResource.setRoleId(roleId);
    		roleResource.setResourceId(Integer.parseInt(resourceId));
    		roleResourceList.add(roleResource);
		}
    	if(roleResourceList.size()>0){
    		roleResourceDao.insertAll(roleResourceList);
    	}
	}
	
	
	/**
	 * 保存分配的用户
	 * @throws Exception	//
	 */
    public void insertRoleUser(String userIds,int roleId)throws Exception{
    	RoleUser ru = new RoleUser();
    	ru.setRoleId(roleId);
    	roleUserDao.deleteByEntity(ru);	
    	
    	List<RoleUser> roleUserList = new ArrayList<RoleUser>();
    	String[] split = userIds.split(",");
    	for (String userId : split) {
    		RoleUser roleUser = new RoleUser();
    		roleUser.setRoleId(roleId);
    		roleUser.setUserId(Integer.parseInt(userId));
    		roleUserList.add(roleUser);
		}
    	if(roleUserList.size()>0){
    		roleUserDao.insertAll(roleUserList);
    	}
	}
    
}
