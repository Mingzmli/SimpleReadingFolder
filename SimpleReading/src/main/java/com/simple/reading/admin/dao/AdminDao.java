package com.simple.reading.admin.dao;

import java.util.List;

import com.simple.reading.admin.form.model.UserInfo;

public interface AdminDao {

	public List<UserInfo> getUserList();
	public UserInfo getUser(UserInfo userInfo);

}
