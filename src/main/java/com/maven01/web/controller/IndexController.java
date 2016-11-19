package com.maven01.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")   
    public String index()
    {
    	System.out.println("这块执行了么");
        return "/web/index";
    }
    
    @RequestMapping("/admin/up_index_img")   
    public String up_index_img()
    {
    	System.out.println("请求 up_index_img");
        return "/admin/up_index_img";
    }
}