package com.maven01.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.RoleResource;
import com.maven01.web.bean.User;
import com.maven01.web.service.RoleService;

/***
 * @描述   角色控制页面
 ***/


@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController{
    
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/gotoList")
	public String gotoList(Model model) throws Exception{
		return "admin/role/list";
	}
	
	
	@RequestMapping("/queryList")
	@ResponseBody
	public Map<String,Object> queryList(int page,int rows,Role role) throws Exception
	{
		
		Map<String,Object> data = new HashMap<String,Object>();
		
		PageHelper.startPage(page, rows);
		List<Role> list = roleService.getListByEntity(role);
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		

		data.put("rows", 		pageInfo.getList());
		data.put("pageSize", 	pageInfo.getPageSize());
		data.put("total", 		pageInfo.getTotal());
		
		return data;
	}
	
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String,Object> save(Role role){
		Map<String,Object> result = this.success(null);
		try{
			roleService.insert(role);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(Role role){
		Map<String,Object> result = this.success(null);
		try{
			roleService.update(role);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Role role){
		Map<String,Object> result = this.success(null);
		try{
			roleService.deleteByEntity(role);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	/*****分配用户、资源************************************************/
	/**
	 * @param roleId
	 * @throws Exception
	 */
	@RequestMapping("/gotoSelectedUserByRoleId")
	public String gotoSelectedUserByRoleId(Model model,int roleId)throws Exception{
		model.addAttribute("roleId",roleId);
		return "role/selectUser";
	}
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId
	 * @throws Exception
	 */
	@RequestMapping("/getSelectedUserByRoleId")
	@ResponseBody
	public List<User> getSelectedUserByRoleId(int roleId)throws Exception{
		return roleService.getSelectedUserByRoleId(roleId);
	}
	
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertRoleUser")
	@ResponseBody
	public Map<String,Object> insertRoleUser(String userIds,int roleId)throws Exception{
		Map<String,Object> result = this.success(null);
		try{
			roleService.insertRoleUser(userIds,roleId);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 根据角色id查询角色所拥有的资源
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSelectedResourceByRoleId")
	@ResponseBody
	public List<RoleResource> getSelectedResourceByRoleId(int roleId)throws Exception{
		return roleService.getSelectedResourceByRoleId(roleId);
	} 
	
	
	/**
	 * 根据角色id查询角色所拥有的用户
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertRoleResource")
	@ResponseBody
	public Map<String,Object> insertRoleResource(String resourceIds,int roleId)throws Exception{
		Map<String,Object> result = this.success(null);
		try{
			roleService.insertRoleResource(resourceIds,roleId);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
}
