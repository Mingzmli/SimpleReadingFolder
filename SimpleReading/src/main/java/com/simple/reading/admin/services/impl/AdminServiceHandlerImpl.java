package com.simple.reading.admin.services.impl;

import java.util.List;

import com.simple.reading.admin.dao.AdminDao;
import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServiceHandler;

public class AdminServiceHandlerImpl implements AdminServiceHandler {

	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void addUser(UserInfo userInfo) {
	
		
	}

	@Override
	public List<UserInfo> getUserList() {
		
		return this.adminDao.getUserList();
	}

	@Override
	public UserInfo getUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return this.adminDao.getUser(userInfo);
	}

}
