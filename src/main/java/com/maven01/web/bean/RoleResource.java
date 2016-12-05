
package com.maven01.web.bean;

public class RoleResource extends BaseB implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;

	private int id;
	private int roleId;//角色id
	private int resourceId;//资源id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
}






