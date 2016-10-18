package com.maven01.web.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.maven01.web.bean.Permission;
import com.maven01.web.bean.Role;
import com.maven01.web.bean.User;
import com.maven01.web.service.UserService;


public class UserRealm extends AuthorizingRealm
{
	
	public Logger logger= Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	
	//授权操作
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
	{
	    String username = (String) principals.getPrimaryPrincipal();
	    
		//直接查找
		List<Role> roles_set = userService.findRolesByUser(username);
		List<Permission> per_list = new ArrayList<Permission>();
		
		
	    //角色集合
	    Set<String> roles = new HashSet<String>();
	    Set<String> permissions = new HashSet<String>();  
	    
	    int i,j,role_id;
	    
	    for(i = 0; i < roles_set.size(); i++)  
        {  
	    	roles.add(roles_set.get(i).getRolename());
	    	role_id=(roles_set.get(i).getId());
	    	
	    	per_list=userService.findPermissionByRoleId(role_id); 		//每个权限放到数组里面
		    for(j = 0; j < per_list.size(); j++)  
	        {  
		    	permissions.add(per_list.get(j).getPermissionname());
	        } 	    	
        } 
	    
	    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    authorizationInfo.addRoles(roles); 	//??? 怎么管理的角色和权限
	    authorizationInfo.addStringPermissions(permissions);

	    return authorizationInfo;
	}
	
	/**身份验证操作  ****/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
	  			throws AuthenticationException 
	{
	
		System.out.println("身份验证。。。");
//		return new SimpleAuthenticationInfo(  
//                "conan", //身份 字符串类型  
//                "12345",   //凭据  
//                getName() //Realm Name  
//        );  

		
		//从提交数据上取到用户名
		String username = (String) token.getPrincipal();		
		User user = userService.findUserByUsername(username);  //从数据库找到该用户
		
		if(user==null)
		{
			System.out.println("用户名搜索出来是空");
			
			//木有找到用户
			throw new UnknownAccountException("没有找到该账号");
		}
		
//		/* if(Boolean.TRUE.equals(user.getLocked())) {  
//              throw new LockedAccountException(); //帐号锁定  
//      	} */
//		/*  数据库里的名字和密码  ?? 提交上来的用户密码不清楚   */
//		
//		System.out.println("user_realm:数据库搜索出来:"+user.getName()+":::"+user.getPass());
//		
//		if (user != null) {
//
//            return new SimpleAuthenticationInfo(user, user.getPass(), user.getName());
//        }
//		
//		return null;
		
		
		SimpleAuthenticationInfo info = 	
			new SimpleAuthenticationInfo(user.getName(), user.getPass(),getName());
		
		logger.info(info);	//显示一下
		
		return info;
		
	  }
	
	  @Override
	  public String getName() 
	  {
		  //当前对象的getName
		  return getClass().getName();
	  }
}





