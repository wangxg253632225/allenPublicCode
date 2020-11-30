package com.dongnaoedu.proxy2.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler {
	
	private Object obj;

	public DynamicProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(obj, args);
	}
}