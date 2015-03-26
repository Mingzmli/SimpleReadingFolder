package com.simple.reading.admin.services.impl;

import java.util.List;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServcie;
import com.simple.reading.admin.services.AdminServiceHandler;

public class AdminSerivceImpl implements AdminServcie {
	
	private AdminServiceHandler adminServiceHandler;

	
	public AdminServiceHandler getAdminServiceHandler() {
		return adminServiceHandler;
	}

	public void setAdminServiceHandler(AdminServiceHandler adminServiceHandler) {
		this.adminServiceHandler = adminServiceHandler;
	}

	@Override
	public void addUser(UserInfo userInfo) {
		this.adminServiceHandler.addUser(userInfo);
		
	}

	@Override
	public List<UserInfo> getUserList() {
		// TODO Auto-generated method stub
		return this.adminServiceHandler.getUserList();
	}

	@Override
	public UserInfo getUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return this.adminServiceHandler.getUser(userInfo);
	}
	
	
	
}
