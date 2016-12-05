package com.maven01.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.maven01.web.bean.User;

public class SessionUtils {
    
	
	public static final String LOGIN_KEY = "loginUser";
	
	public static User getLoginUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(LOGIN_KEY);
		return user;
	}
}
