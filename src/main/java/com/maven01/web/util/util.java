package com.maven01.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class util
{	
    // 判断是否 AJAX 请求
    public static boolean useAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
	
	static String get_web_path()
	{	
		return null;
	}
	
	
	//获取系统毫秒时间，并装换成字符串
	static public String refFormatNowDate()
	{
		  Date nowTime = new Date(System.currentTimeMillis());
		  SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");//"yyyy-MM-dd");
		  String retStrFormatNowDate = sdFormatter.format(nowTime);
		  return retStrFormatNowDate;
	}
	
	//获取系统毫秒时间，并装换成字符串--是个数字
	static public Date getNowDate()
	{
		  Date nowTime = new Date(System.currentTimeMillis());
		  return nowTime;
	}
	
	static public String get_suffix(String total_name)
	{
		String suffix="";
		suffix=total_name.substring(
								total_name.lastIndexOf(".")+1,
								total_name.length()
							);
		
		return suffix;
	}
}
