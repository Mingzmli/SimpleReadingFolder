package com.simple.reading.admin.form.model;

import java.util.List;

import com.simple.reading.admin.entities.ArticalEntity;

public class UserInfo {
	
	private String id;

	private String username;

	private String password;

	private int roleLevel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}	
	
	

}
