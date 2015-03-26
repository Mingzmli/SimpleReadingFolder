package com.simple.reading.admin.entities;

import java.io.Serializable;
import java.util.List;

public class RoleEntity implements Serializable {

	private static final long serialVersionUID = -8114987897604609427L;

	private String id;

	private int roleLevel;

	private String roleName;

	private List<UserEntity> userEnties;

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

	public List<UserEntity> getUserEnties() {
		return userEnties;
	}

	public void setUserEnties(List<UserEntity> userEnties) {
		this.userEnties = userEnties;
	}

}
