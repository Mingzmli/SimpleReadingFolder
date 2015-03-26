package com.simple.reading.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.simple.reading.admin.entities.UserEntity;
import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.utils.MD5Converter;

public class AdminDaoImpl implements AdminDao {

	private AdminContext adminContext;

	public AdminContext getAdminContext() {
		return adminContext;
	}

	public void setAdminContext(AdminContext adminContext) {
		this.adminContext = adminContext;
	}

	@Override
	public List<UserInfo> getUserList() {
		
		return this.convert2UserInfo(this.adminContext.getUserMapper()
				.getUserAll());
	}

	private List<UserInfo> convert2UserInfo(List<UserEntity> userEntities) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		userInfos.clear();
		for (UserEntity user : userEntities) {
			UserInfo userInfo = this.UserEntity2UserInfo(user);
			userInfos.add(userInfo);
		}

		return userInfos;

	}

	@Override
	public UserInfo getUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		UserEntity user = this.adminContext.getUserMapper().getUserByUsername(userInfo.getUsername());
		return this.UserEntity2UserInfo(user);
		
	}
	
	private UserInfo UserEntity2UserInfo(UserEntity user){		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setUsername(user.getUsername());
		userInfo.setPassword(user.getPassword());
		userInfo.setRoleLevel(user.getRoleLevel());		
		return userInfo;
		
	}
	

}
