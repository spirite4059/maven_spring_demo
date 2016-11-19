package com.maven01.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class util
{	
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
	
	//获取系统毫秒时间，并装换成字符串
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
