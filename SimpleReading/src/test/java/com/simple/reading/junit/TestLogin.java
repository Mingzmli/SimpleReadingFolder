package com.simple.reading.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServcie;
import com.simple.reading.utils.MD5Converter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestLogin {

	@Autowired
	public AdminServcie adminServcie;
	
	@Test
	public void testLogin(){
		
		UserInfo userLogin = new UserInfo();

		String password = MD5Converter.md5(MD5Converter.md5("admin9901828928"));
		
		userLogin.setUsername("SimpleReadingAdmin");
		userLogin.setPassword(password);
		
		UserInfo userInfo = adminServcie.getUser(userLogin);
		System.out.println(userLogin.getPassword());
		System.out.println(userInfo.getPassword());
		if(userLogin.getPassword().equals(userInfo.getPassword()))
		{
			System.out.println(true);
		}
		
		System.out.println(userInfo);
		
		
	}
}
