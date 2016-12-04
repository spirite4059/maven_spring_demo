package com.maven01.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.maven01.web.service.ArticleBlockService;
import com.maven01.web.service.ResourceService;


@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController 
{
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResourceService resourceSerivice;
	
	@RequestMapping("home")
	public String home(){
		return "/admin/login";
	}
	
    @RequestMapping("/index")    
    public String article(ModelMap modelMap,@RequestParam(required=false) Integer articleId)
    {
    	logger.info("请求 admin/index:");
        return "/admin/index";
    }
    
    //登陆页面
    
    
    
    
}
