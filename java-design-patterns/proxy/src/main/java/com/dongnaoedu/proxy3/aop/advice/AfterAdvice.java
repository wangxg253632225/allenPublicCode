package com.dongnaoedu.proxy3.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知
 * 
 * @author allen
 */
public class AfterAdvice implements AfterReturningAdvice {

    /*
     * returnValue 返回值
     * method 被调用的方法
     * args 方法参数
     * target 被代理对象
     */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("-----------------后置通知-----------------");
	}

}
