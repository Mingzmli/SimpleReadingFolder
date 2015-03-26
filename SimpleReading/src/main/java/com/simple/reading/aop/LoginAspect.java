package com.simple.reading.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginAspect {
	
	@Before("execution(* com.simple.reading.admin.services.*.*(..))")
	public void before(){	
		   System.out.println("login before!!!!!!!!!!");  
	}
	
	
}
