package com.maven01.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;  

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;  
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.mvc.support.RedirectAttributes;  

import com.maven01.web.bean.User;



@Controller
public class HomeController 
{
	
	public Logger logger= Logger.getLogger(getClass());
	
   @RequestMapping(value="/login",method=RequestMethod.GET)  
   public String loginForm(Model model)
   {  
	    System.out.println("get login");
        
	    model.addAttribute("user", new User());  
        return "/login";  
   }  
	      
   @RequestMapping(value="/login",method=RequestMethod.POST)  
   public String login(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
   {   
       try {  
    	   String userName=request.getParameter("username");
    	   String passWord=request.getParameter("password");
           
           System.out.println("post的数据：user="+userName+"|||pass="+passWord);
           
           //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！           
           SecurityUtils.getSubject().login(new UsernamePasswordToken(userName, passWord));  
           return "redirect:/user"; 	//跳转到原始页面，妈的
       } 
       catch (AuthenticationException e)
       {  
    	   System.out.println("message:"+"用户名或密码错误");
           redirectAttributes.addFlashAttribute("message","用户名或密码错误");  
           return "redirect:/login";  
       }  
   }  
   
   
   @RequestMapping(value="/logout",method=RequestMethod.GET)    
   public String logout(RedirectAttributes redirectAttributes )
   {   
       //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
       SecurityUtils.getSubject().logout();    
       redirectAttributes.addFlashAttribute("message", "您已安全退出");    
       return "redirect:/login";  
   }   
   
   
   @RequestMapping(value="/user",method=RequestMethod.GET)    
   public String show_user( )
   {   
	   //判断登录用户，然后根据用户信息显示不同内容conana
	   logger.info("request user,运行这里了么");
	   
       return "/user";  
   }   
     
   
   @RequestMapping("/403")  
   public String unauthorizedRole(){  
       return "/403";  
   }
   
   
}







