package com.maven01.web.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User 
{
    private Integer id;
    private String name;
    private String pass;
    private Date createDate;
    
    private List<Role> roleList;//一个用户具有多个角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    public List<Role> getRoleList() {  
        return roleList;  
    }  
    
    public void setRoleList(List<Role> roleList) {  
        this.roleList = roleList;  
    }  
    
    //把角色里面数据拿出来放到列表里面
    public Set<String> getRolesName(){  
        List<Role> roles=getRoleList();  
        Set<String> set=new HashSet<String>();  
        for (Role role : roles) {  
            set.add(role.getRolename());  
        }  
        return set;  
    }  
}




