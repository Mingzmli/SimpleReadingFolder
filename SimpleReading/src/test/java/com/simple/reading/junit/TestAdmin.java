package com.simple.reading.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.entities.RoleEntity;
import com.simple.reading.admin.entities.UserEntity;
import com.simple.reading.admin.mapper.RoleMapper;
import com.simple.reading.admin.mapper.UserMapper;
import com.simple.reading.admin.services.AdminServcie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAdmin {

	@Autowired
	public AdminServcie adminServcie;

	@Autowired
	public RoleMapper roleMapper;

	@Autowired
	public UserMapper userMapper;
	
	
	
	@Test 
	public void testGetUserByRoleLevel()
	{
		
		RoleEntity roleEntity = roleMapper.getRoleByLevel(3);
		
		List<UserEntity> userEntities = roleEntity.getUserEnties();
		
//		List<UserEntity> UserEntities = roleEntity.getUserEnties();
//		
		System.out.println(userEntities.size());
	}
	
	@Test
	public void testListRoleForUser(){
			
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUsername("aaa2");
		userEntity.setPassword("aaa2");
		userEntity.setRoleLevel(3);
		
		userMapper.addUser(userEntity);
		
		System.out.println("add user");
		
	}
	
	
	@Test
	public void testAddUser() {

		UserEntity userEntity = new UserEntity();

		userEntity.setUsername("testUser1");
		userEntity.setPassword("aaaaa");
		userEntity.setRoleLevel(1);
		userMapper.addUser(userEntity);

		System.out.println("add succeed");

	}

	@Test
	public void testAdd() {
		// ApplicationContext act = new ClassPathXmlApplicationContext(
		// "/applicationContext.xml");
		RoleEntity roleEntity = new RoleEntity();

		roleEntity.setRoleLevel(5);
		roleEntity.setRoleName("Role1with key");

		roleMapper.addRole(roleEntity);

		System.out.println(roleEntity.getId());
	}

	@Test
	public void testRoleMapper() {

		List<RoleEntity> RoleEntitys = roleMapper.getRoleAll();

		for (RoleEntity roleEntity : RoleEntitys) {
			System.out.println(roleEntity.getRoleName());
		}

	}

	@Test
	public void testAddRole() {

		RoleEntity roleEntity = new RoleEntity();

		roleEntity.setRoleLevel(1);
		roleEntity.setRoleName("insertRole1");

		roleMapper.addRole(roleEntity);

	}

	@Test 
	public void  testDeleteRole(){
		RoleEntity roleEntity = roleMapper.getRoleByLevel(2);
		
		roleMapper.deleteRole(roleEntity);
	}
	
	@Test
	public void testUpdateRole(){
		
		RoleEntity roleEntity = roleMapper.getRoleByLevel(2);
		roleEntity.setRoleName("updateRoleName");
		roleMapper.updateRole(roleEntity);
	}
	
	@Test
	public void testUpdateUsername()
	{
		UserEntity userEntity = userMapper.getUserByUsername("testUser1");
		userEntity.setPassword("888888");
		userMapper.updateUserByUsername(userEntity);
	}
	
	@Test
	public void testDeleteUser(){
		
		UserEntity userEntity = userMapper.getUserByUsername("testUser1");
		userMapper.deleteUserByUsername(userEntity);
	}
}
