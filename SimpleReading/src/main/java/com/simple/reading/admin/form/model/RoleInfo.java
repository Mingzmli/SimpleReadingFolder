package com.simple.reading.admin.form.model;

import java.util.List;

public class RoleInfo {
	
	private String id;
	
	private int roleLevel;
	
	private String roleName;
	
	/*
	 * Related Object
	 */
	private List<UserInfo> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	
	
}
