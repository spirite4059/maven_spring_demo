package com.maven01.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("./index")   
    public String index()
    {
    	System.out.println("这块执行了么");
        return "./index";
    }
}