package com.maven01.web.controller;

import java.util.List;
import com.maven01.web.bean.User;
import com.maven01.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController 
{
	@RequestMapping("/product_list")
	public String show()
	{
		System.out.println("show");
		return "/product_list";
	}

	@RequestMapping("/product_search")   
	public String index1()
	{
		System.out.println("index1");
	    return "/product_search";
	}
}


