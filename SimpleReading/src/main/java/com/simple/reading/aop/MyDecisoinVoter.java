package com.simple.reading.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
//public class MyDecisoinVoter {
//
//	/**
//	 * 得到request的方法 1.HttpServletRequest request = ((ServletRequestAttributes)
//	 * RequestContextHolder .getRequestAttributes()).getRequest(); 2.如下
//	 */
////	@Autowired(required = true)
//	private HttpServletRequest request;
//	@Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
//	public Object authPermission(JoinPoint joinPoint) throws Throwable {
////		MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
////		MethodSignature methodSignature = (MethodSignature) methodJoinPoint
////				.getSignature();
////		java.lang.reflect.Method method = methodSignature.getMethod();
////		
////		String username = request.getParameter("username");
////		
////		System.out.println("username---->  " + username);
////		
//////		return new ModelAndView("index");
//		System.out.println("username");
//		return null;
//
//	}
//
//
//}



public class MyDecisoinVoter {
	public MyDecisoinVoter() {
		System.out.println("Aop");
	}
	
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {}
	
	// @Around("within(org.springframework.web.bind.annotation.support.HandlerMethodInvoker..*)")
	//@Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	@Before("controller()")
	public Object aa(ProceedingJoinPoint pjp)  throws Throwable 
	{
		try {
			Object retVal = pjp.proceed();
			System.out.println("testing....................");
			return retVal;
		} catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}
}

