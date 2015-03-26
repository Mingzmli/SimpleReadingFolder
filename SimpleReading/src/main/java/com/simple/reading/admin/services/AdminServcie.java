package com.simple.reading.admin.services;

import java.util.List;

import com.simple.reading.admin.form.model.UserInfo;

public interface AdminServcie {
	public void addUser(UserInfo userInfo);
	public List<UserInfo> getUserList();
	public UserInfo getUser(UserInfo userInfo);
}
