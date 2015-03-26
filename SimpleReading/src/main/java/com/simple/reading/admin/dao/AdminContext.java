package com.simple.reading.admin.dao;

import com.simple.reading.admin.mapper.ArticalMapper;
import com.simple.reading.admin.mapper.RoleMapper;
import com.simple.reading.admin.mapper.UserMapper;

/*
 * 
 * All Mapper integration
 */

public class AdminContext {

	private UserMapper userMapper;
	
	private RoleMapper roleMapper;
	
	private ArticalMapper articalMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public ArticalMapper getArticalMapper() {
		return articalMapper;
	}

	public void setArticalMapper(ArticalMapper articalMapper) {
		this.articalMapper = articalMapper;
	}
	
	
}
