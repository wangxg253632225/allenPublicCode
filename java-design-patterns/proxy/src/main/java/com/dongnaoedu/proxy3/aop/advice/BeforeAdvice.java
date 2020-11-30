package com.dongnaoedu.proxy3.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知
 * 
 * @author allen
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	/**
	 * method 方法信息 
	 * args 参数 
	 * target 被代理的目标对象
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("-----------------前置通知-----------------");
	}

}
