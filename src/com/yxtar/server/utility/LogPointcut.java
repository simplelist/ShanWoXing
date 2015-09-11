package com.yxtar.server.utility;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * AOP-pointer 指出要切入的点 ,Pointcut：表示一组 joint point，这些 joint point
 * 或是通过逻辑关系组合起来，或是通过通配、正则表达式等方式集中起来，它定义了相应的 Advice 将要发生的地方。
 * @author wufeng
 */
@Aspect
public class LogPointcut {

  @Pointcut("execution(* com.yxtar.server.service..*.*(..))")
  public void inServiceLayer() {

  }

}
