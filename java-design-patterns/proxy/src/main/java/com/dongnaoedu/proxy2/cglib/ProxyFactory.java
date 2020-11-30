package com.dongnaoedu.proxy2.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib子类代理工厂
 * 对BuyTicket在内存中动态构建一个子类对象
 * 
 * @author allen
 *
 */
public class ProxyFactory implements MethodInterceptor {

	// 维护目标对象
	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 1.工具类
		Enhancer en = new Enhancer();
		// 2.设置父类
		en.setSuperclass(target.getClass());
		// 3.设置回调函数
		en.setCallback(this);
		// 4.创建子类(代理对象)
		return en.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("***********开车去买票路上***********");
		
		// 执行目标对象的方法
		Object returnValue = method.invoke(target, args);
		
		System.out.println("***********买到票高高兴兴的回家***********");
		
		return returnValue;
	}
}
