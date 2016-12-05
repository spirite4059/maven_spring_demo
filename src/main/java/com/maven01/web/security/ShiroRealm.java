package com.maven01.web.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.maven01.web.bean.Resource;
import com.maven01.web.bean.User;
import com.maven01.web.service.ResourceService;
import com.maven01.web.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Refer: http://www.ibm.com/developerworks/cn/java/j-lo-shiro/
 * Shiro 从 Realm 获取安全数据(如用户、角色、权限), 就是说 SecurityManager 要验证用户身份,
 * 那么它需要从 Realm 获取相应的用户进行比较以确定用户身份是否合法。
 * 也需要从 Realm 得到用户相应的角色/权限进行验证用户是否能进行操作;
 * 可以把 Realm 看成 DataSource, 即安全数据源。 
 */

public class ShiroRealm extends AuthorizingRealm 
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private Map<String, String> usernamePasswords;
    private Map<String, List<String>> usernameRoles;

    @Autowired(required = true)
    public UserService userService; 
    
    @Autowired(required =true)
    public ResourceService resourceService;	
    
    
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	

	@Override
	public void setName(String name) {
		super.setName("ShiroRealm");
	}
	
	
	//密码账号验证---会把异常直接写入到request里面
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException 
	{						     //这个token是在form的验证 filter生成的的pass/user token
		String userName=(String) token.getPrincipal();  			//从form里面获得的username
		User user = null;	
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;	
		try
		{
			user = userService.getLoginUser(userName);	//同一个用户名可以有两个账号么？？？ 不是会异常
			if(user == null)
				throw new UnknownAccountException();	
			else if(user.getStatus()==2) 
				throw new LockedAccountException();		
			
			String dbpassword=user.getPassword();
			//String dbusername=user.getUsername();   //这个地方可以放user对象
										//shiro会做数据库信息和token信息的比较，正常返回就可以了
			simpleAuthenticationInfo  = new SimpleAuthenticationInfo(user,dbpassword,this.getName());
			logger.debug("当前：doGetAuthenticationInfo");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return simpleAuthenticationInfo;
	}
	
	
	@Override		
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
	{
		// 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
		// (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
		if (!SecurityUtils.getSubject().isAuthenticated()) 
		{
			doClearCache(principals);	//如果
			SecurityUtils.getSubject().logout();  //显性调用退出
			return null;
		}
		
		User user =  (User) principals.getPrimaryPrincipal();	  //这个地方的principles放的什么，怎么放进来的？？cation里面放的？
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		List<Resource> resourceList = null;
		
		logger.debug("当前：doGetAuthorizationInfo");
		
		try {
			resourceList = resourceService.getUserResourceList(user.getId());   
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> permissions = new ArrayList<String>();
		for (Resource resource : resourceList) {
			permissions.add(resource.getUrl());
		}
		
		info.addStringPermissions(permissions);
		return info;
	}
	

	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	
	/*****
    public ShiroRealm() 
    {
        usernamePasswords = new HashMap<String, String>();
        usernameRoles = new HashMap<String, List<String>>();

        usernamePasswords.put("admin", "password");
        usernamePasswords.put("register", "password");

        usernameRoles.put("admin", Arrays.asList("Register", "Admin"));
        usernameRoles.put("register", Arrays.asList("Register"));
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername(); // 通过表单接收的用户名

        if (username.equals("test")) {
            throw new LockedAccountException("Account is locked"); //帐号锁定
        }

        User user = userService.getUserById(1);
        System.out.println(user);

        // 取得预先定义的用户名密码对
        return new SimpleAuthenticationInfo(username, queryPassword(username), getName());
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
    {
    	//需要按照之前的方式来编写？？？
    	
    	
    	
        // 用户需要提供 principals (身份)和 credentials(证明)给 shiro,从而应用能验证用户身份
        // 最常见的 principals 和 credentials 组合就是用户名/密码了
        // String username = (String) principals.fromRealm(getName()).iterator().next();
        String username = (String) principals.getPrimaryPrincipal();

        // Authentication 成功后查询用户授权信息.
        List<String> roles = queryRoles(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        logger.debug("Username: {}, Roles: {}", username, roles);

        if (roles != null && !roles.isEmpty()) {
//	        info.addStringPermissions(permissions);
            info.addRoles(roles);
        }

        return info;
    }

    private String queryPassword(String username) {
        return usernamePasswords.get(username);
    }

    private List<String> queryRoles(String username) {
        return usernameRoles.get(username);
    }
    
    */
}