package com.simple.reading.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ScopeHelper {
	
	public static void setSessionValue(HttpServletRequest request ,String key,Object value)
	{
		 HttpSession session = request.getSession(); 
		 
		 session.setAttribute(key, value);
	}
	
	public static Object getSesionValue(HttpServletRequest request ,String key,boolean willNew)
	{
		
		return request.getSession(willNew).getAttribute(key);
	}
}
