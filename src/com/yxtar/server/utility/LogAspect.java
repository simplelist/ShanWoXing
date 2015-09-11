package com.yxtar.server.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before(value = "execution(public * com.yxtar.server.service..*.*(..))")
	public void beforeShow(JoinPoint point) {
		System.out.println("------------->"+point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + " before show.");
	}

	@After(value = "execution(public * com.yxtar.server.service..*.*(..))")
	public void afterShow(JoinPoint point) {
		System.out.println("------------->"+point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + " after show.\n");
	}

}
