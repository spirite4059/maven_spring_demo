package com.maven01.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven01.web.bean.Resource;
import com.maven01.web.service.ResourceService;


@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
    
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/gotoList")
	public String gotoList(Model model) throws Exception{
		return "resource/list";
	}
	
	
	@RequestMapping("/queryList")
	@ResponseBody
	public List<Resource> queryList() throws Exception{
		int parentId = -1;
		List<Resource> treeList = new ArrayList<Resource>();
		return resourceService.getTreeList(parentId, treeList);
	}
	
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String,Object> save(Resource resource){
		Map<String,Object> result = this.success(null);
		try{
			resourceService.insert(resource);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/gotoUpdate")
	@ResponseBody
	public Resource gotoUpdate(int id) throws Exception{
		return resourceService.getEntityById(id);
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(Resource resource){
		Map<String,Object> result = this.success(null);
		try{
			resourceService.update(resource);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Resource resource){
		Map<String,Object> result = this.success(null);
		try{
			resourceService.deleteByEntity(resource);
		}catch(Exception e){
			result = this.error(e.getMessage());
		}
		return result;
	}
	
}