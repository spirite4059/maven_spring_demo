package com.maven01.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven01.web.bean.User;
import com.maven01.web.service.UserService;
import com.maven01.web.util.Md5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;
	
	//在主页第一个tab显示说明文件
	@RequestMapping("/gotoUpgradeIndex")
	public String gotoUpgradeIndex(Model model) throws Exception{
		return "admin/upgrade/index";
	}
	
	//用户相关操作
	@RequestMapping("/gotoList")
	public String gotoList(Model model) throws Exception{
		return "admin/user/list";
	}
	
	/**
	 * 检验用户名的唯一性
	 * @author limr
	 * @param id
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkUserName")
	@ResponseBody
	public String checkUserName(int id, String userName) throws Exception{
		String data = "false";
		User user = userService.getUserByUserName(id, userName);
		if(user == null){
			data = "true";		//???没有用户的时候，返回为真
		}
		return data;
	}
	
	/**
	 * 检验输入的旧密码是否正确
	 * @param id
	 * @param oldPwd
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkOldPwd")
	@ResponseBody
	public boolean checkOldPwd(int id, String oldPwd) throws Exception{
		boolean data = false;
		User user = userService.getEntityById(id);
		String pwd = user.getPassword();
		if(pwd.equals(Md5Util.md5(oldPwd))){	//用md5工具检查密码是否相同
			data = true;
		}
		return data;
	}
	
	
	//请求分页;easyui自动进行处理
	@RequestMapping("/queryList")
	@ResponseBody
	public Map<String,Object> queryList(int page,int rows,User user) throws Exception
	{
		Map<String,Object> data = new HashMap<String,Object>();
		
		PageHelper.startPage(page, rows);
		List<User> list = userService.getListByEntity(user);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		data.put("rows", 		pageInfo.getList());
		data.put("pageSize", 	pageInfo.getPageSize());
		data.put("total", 		pageInfo.getTotal());
		return data;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String,Object> save(User user){
		Map<String,Object> result = this.success(null);
		try{
			User u = userService.getUserByUserName(user.getId(), user.getUsername());
			if(u == null || "".equals(u)){
				user.setCreatetime(new Date());
				user.setPassword(Md5Util.md5(user.getPassword()));
//				user.setStatus(1);
				userService.insert(user);
			}else{
				result = this.error("用户名已存在！");
			}
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(User user){
		Map<String,Object> result = this.success(null);
		try{
			User u = userService.getUserByUserName(user.getId(), user.getUsername());
			if(u == null || "".equals(u)){
				String pwd = user.getPassword();
				if(StringUtils.isNotBlank(pwd)){
					user.setPassword(Md5Util.md5(user.getPassword()));
				}
				userService.update(user);
			}else{
				result = this.error("用户名已存在！");
			}
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(User user){
		Map<String,Object> result = this.success(null);
		try{
			userService.deleteByEntity(user);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
}






