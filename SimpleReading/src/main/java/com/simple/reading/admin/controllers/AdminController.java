package com.simple.reading.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServcie;

@Controller
@RequestMapping(value = "/simplekuy6927simpleadmin")
public class AdminController {
//
//	@Autowired
//	private AdminServcie adminServcie;
//	
//	public AdminServcie getAdminServcie() {
//		return adminServcie;
//	}
//	
//	public void setAdminServcie(AdminServcie adminServcie) {
//		this.adminServcie = adminServcie;
//	}
//
//	/*
//	 * index get request
//	 */
//	@RequestMapping(value = "/index", method = { RequestMethod.GET })
//	public ModelAndView index() {
//		ModelAndView modelAndView = new ModelAndView();
//		// modelAndView.addObject("message", "Hello World! Ming");
//		modelAndView.setViewName("manageadmin/index");
//		return modelAndView;
//	}
//
//	/*
//	 * Manage User get request
//	 */
//	@RequestMapping(value = "/mangeuser", method = { RequestMethod.GET })
//	public ModelAndView workforuser() {
//		
//		List<UserInfo> userInfos = adminServcie.getUserList();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("userInfos", userInfos);
//		modelAndView.setViewName("manageadmin/mangeuser");
//		return modelAndView;
//	}
//	
//	/*
//	 * Manage Role get request
//	 */
//	@RequestMapping(value = "/mangerole", method = { RequestMethod.GET })
//	public ModelAndView workforrole() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("message", "Hello World! Ming");
//		modelAndView.setViewName("manageadmin/mangerole");
//		return modelAndView;
//	}
//	
}