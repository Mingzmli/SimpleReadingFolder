package com.simple.reading.admin.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.admin.services.AdminServcie;
import com.simple.reading.utils.ScopeHelper;
import com.simple.reading.validate.SimpleValidate;

@Controller
@RequestMapping(value = "/simplelsy3618simplelogin")
public class LoginController {

	private final static String REDIRECT_CONTROLLER ="redirect:/simpleslty6435simpleartical"; 
	
	private final static String REDIRECT_INDEX_ARTICLE_REQUEST = REDIRECT_CONTROLLER+"/index";
	
	private final static String REDIRECT_ADD_ARTICLE_REQUEST = REDIRECT_CONTROLLER+"/addartical";
	
	private final static String REDIRECT_LOGIN_REQUEST = "redirect:manageartical/artical-add";	
	
	
	@Autowired
	private AdminServcie adminServcie;

	public AdminServcie getAdminServcie() {
		return adminServcie;
	}

	public void setAdminServcie(AdminServcie adminServcie) {
		this.adminServcie = adminServcie;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("message", "Hello World! Ming");
		modelAndView.setViewName("managelogin/login");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request, Model model,
			@ModelAttribute("articleInfo") UserInfo userInfo) {

		String sessionVcode = (String) request.getSession().getAttribute("vCode");
		String requestVcode = request.getParameter("verifyCode");
		ModelAndView modelAndView = new ModelAndView();
			
		boolean checkedFlag = false;
		
		UserInfo dbUserInfo =null;
		
		if(userInfo!=null)
		{
			dbUserInfo = this.adminServcie.getUser(userInfo);
			checkedFlag = SimpleValidate.UserValidate(dbUserInfo, userInfo,
					requestVcode, sessionVcode);
		}		

		if (!checkedFlag) {
			
			modelAndView.addObject("userInfo", userInfo);

			modelAndView.setViewName(REDIRECT_LOGIN_REQUEST);
		}
		
		ScopeHelper.setSessionValue(request, "userInfo", dbUserInfo);
		
		modelAndView.setViewName(REDIRECT_INDEX_ARTICLE_REQUEST);

		return modelAndView;
	}

}
