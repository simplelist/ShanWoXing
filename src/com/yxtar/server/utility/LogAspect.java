package com.yxtar.server.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	static Logger log = LogManager.getLogger();

	@Before(value = "execution(public * com.yxtar.server.service..*.*(..))")
	public void beforeDao(JoinPoint point) {
		log.info(point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + " before........");
	}

	@After(value = "execution(public * com.yxtar.server.service..*.*(..))")
	public void afterDao(JoinPoint point) {
		log.info(point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "  after........");
	}

}
