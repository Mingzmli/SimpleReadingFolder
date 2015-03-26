package com.simple.reading.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simple.reading.admin.entities.RoleEntity;
import com.simple.reading.admin.entities.UserEntity;
import com.simple.reading.admin.mapper.RoleMapper;
import com.simple.reading.admin.mapper.UserMapper;

public class TestMapper {
	
	
	@Test
	public void testMapper()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext(
		"/applicationContext.xml");
		
		UserMapper userMapper =  (UserMapper)act.getBean("userMapper");
		

		UserEntity userEntity = userMapper.getUserById("02712948-c47f-11e4-8717-005056c00008");
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getUsername());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity.getRoleLevel());
		System.out.println(userEntity.getArticalEntities().size());
		
	}
	
	
	
	
}
