package com.simple.reading.admin.entities;

import java.io.Serializable;
import java.util.List;

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5916186365265175299L;

	private String id;

	private String username;

	private String password;

	private int roleLevel;	

	private List<ArticalEntity> ArticalEntities;

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

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

	public List<ArticalEntity> getArticalEntities() {
		return ArticalEntities;
	}

	public void setArticalEntities(List<ArticalEntity> articalEntities) {
		ArticalEntities = articalEntities;
	}

}
