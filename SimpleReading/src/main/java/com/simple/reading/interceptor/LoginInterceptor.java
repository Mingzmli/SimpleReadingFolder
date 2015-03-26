package com.simple.reading.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simple.reading.admin.form.model.UserInfo;
import com.simple.reading.exception.AuthorizationException;
import com.simple.reading.utils.ScopeHelper;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub

		UserInfo userInfo = (UserInfo) ScopeHelper.getSesionValue(arg0,
				"userInfo", true);

		if (userInfo == null) {
			throw new AuthorizationException();

		} else {
			return true;
		}


	}

}
