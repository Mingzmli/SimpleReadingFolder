package com.simple.reading.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServcie;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestIntegrate {

	@Autowired
	private AdminServcie adminServcie;
	
	public AdminServcie getAdminServcie() {
		return adminServcie;
	}

	public void setAdminServcie(AdminServcie adminServcie) {
		this.adminServcie = adminServcie;
	}



	@Test
	public void testIntegrate(){
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUsername("Test-1");
		userInfo.setPassword("123123");
		userInfo.setRoleLevel(1);
		
		adminServcie.addUser(userInfo);
		
		System.out.println();
	}
}
