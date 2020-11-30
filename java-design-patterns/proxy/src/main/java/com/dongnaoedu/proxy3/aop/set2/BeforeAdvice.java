package com.dongnaoedu.proxy3.aop.set2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/** 前置通知 */
public class BeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] objects, Object o) throws Throwable {
		System.out.println("调用方法" + method.getName() + "前完成的工作！");
	}
}

/** 后置通知 */
class AfterAdvice implements AfterReturningAdvice {
	public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
		System.out.println("结束方法" + method.getName() + "前完成的工作！");
	}
}

/** 环绕通知 */
class SurroundAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕通知_前");
		// 调用要执行的方法并返回结果
		Object result = methodInvocation.proceed();
		System.out.println("环绕通知_后");
		return result;
	}
}
