package com.maven01.web.bean;

import java.util.List;

public class Resource {
    private Integer id;			
    private String url;			//资源URL
    private String text;		//资源名
    private String remark;		//备注
    private Integer parentId;	//父级别id
    private Integer isMenu;		//是否显示菜单 1.显示  2.隐藏
    private Integer isVirtual;	//是否虚拟      1.虚拟  2、非虚拟
    private String menuCls;		//菜单样式（图片）
    private Integer sort;		//排序值 
    private Integer roleid;		//临时，角色id
    private Integer userid;		//临时，用户id
 
	private List<Resource> children;		//为了方便查找的资源子节点	
    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getUrl() {
        return url;
    }

    
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentid) {
        this.parentId = parentid;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getMenuCls() {
        return menuCls;
    }

    public void setMenuCls(String menuCls) {
        this.menuCls = menuCls == null ? null : menuCls.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
	public List<Resource> getChildren() {
		return children;
	}
	
	//设置 
	public void setChildren(List<Resource> children) {
		this.children = children;
	}
	
}





