package com.maven01.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.maven01.web.bean.UpImage;
import com.maven01.web.service.ImageService;
import com.maven01.web.util.util;



@Controller
@RequestMapping("/up_img")
public class ImgController {
	
	//private static final Logger LOGGER = Logger.getLogger(ImgController.class);
	
	@Autowired
	private ImageService img_service;
	
	//post上来的多个图片；使用jquery_file_upload插件上传的多个图片
    @RequestMapping(value="/mul_img", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception 
    {
    	//获取传上来的图片
    	Iterator<String> itr=request.getFileNames();
    	MultipartFile mpf=null;
    	
    	//拼返回字符串json
    	String return_str;
    	return_str= "{\"files\": [";
    	
    	boolean is_first=true;	//用来判断是不是第1个，是的话就不放","
    	
    	while(itr.hasNext())
    	{
    		//获取当前上传的文件
    		mpf=request.getFile(itr.next());
    		
    		try{
    			
              String fold_path = request.getSession().getServletContext().getRealPath(""); 	//获得项目的绝对路径
              fold_path+="\\img\\up_img\\";
              String web_path="/img/up_img/";
              
              //得到图片的名字
              String file_name=mpf.getOriginalFilename();
              //获取文件后缀然后放到文件处理的相关内容上去
              String suffix=util.get_suffix(file_name);
              
              //LOGGER.info("图片地址："+fold_path);
              //LOGGER.info("图片名称："+file_name);
              
              
              //获取当前的系统时间
              String time_str = util.refFormatNowDate();
              String img_name="img"+time_str;
              String img_str="img"+time_str+"."+suffix;
              String thumb_str="thumb"+time_str+"."+suffix;
              
              //获取图片的大小
              String size_str=mpf.getSize()/1024+"Kb";
                     
              //获取图片(文件)的后缀,生成一个带后缀的文件 
              FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(fold_path+img_str));
              
              
              //在同样的文件位置上生成成缩略图
              Thumbnails.of(new File(fold_path+img_str))
              .size(80, 80)
              .toFile(new File(fold_path+thumb_str));
              
              
              //保存数据信息到数据库里面
          		UpImage img_bean=new UpImage();
          		img_bean.setImgName(img_name);
          		img_bean.setImgType(0);
          		img_bean.setImgUrl(web_path+img_str);
          		img_bean.setImgThumbUrl(web_path);
          		img_bean.setImgDate(util.getNowDate());
          		
              
                img_service.insert_img(img_bean);//插入数据库数据
                
                if(!is_first)return_str+=",";
                else is_first=false;
                	
                
                return_str+="{"+"\"name\": \""+img_name+"\","+
                			"\"size\":\""+size_str+"\","+
                			"\"url\": \""+web_path+img_str+"\","+
            			    "\"thumbnailUrl\": \""+web_path+thumb_str+"\","+
            			    "\"deleteUrl\": \"null\","+
            			    "\"deleteType\": \"DELETE\" " +
            			    "}"; 
                
    		}catch(IOException e){
    			e.printStackTrace();
    			return null;	//如果失败的话，输出json字符串
    		}
    	}
    	
    	return_str+="]}"; 
    	
    	return return_str;
    }
}
