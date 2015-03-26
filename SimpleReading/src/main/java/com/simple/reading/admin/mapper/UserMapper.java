package com.simple.reading.admin.mapper;

import java.util.List;

import com.simple.reading.admin.entities.UserEntity;

public interface UserMapper {

	public UserEntity getUserByUsername(String username);

	public UserEntity getUserById(String id);
	
	public List<UserEntity> getUserAll();

	public void addUser(UserEntity userEntity);

	public List<UserEntity> getUserByRoleLevel(int level);
	
	public void updateUserByUsername(UserEntity userEntity);
	
	public void deleteUserByUsername(UserEntity userEntity);
	
	public void deleteUserById(UserEntity userEntity);
	

}
