package com.dongnaoedu.proxy2.jdk;

import java.lang.reflect.Proxy;

/**
 * 测试类 - 动态代理
 * 
 * @author allen
 * 
 */
public class App {
	public static void main(String[] str) {
		// 用户信息
		User user = new User();
		user.setCardCode("430488888888888888");
		user.setSex("男");
		user.setName("Allen老师");
		user.setHomeAddress("湖南省.长沙市.动脑学院");

		// 创建买票者
		IProxy zhangsan = new RealProxy(user);
		// 创建动态代理
		DynamicProxy proxy = new DynamicProxy(zhangsan);
		// 获取被代理的classloader
		ClassLoader loader = zhangsan.getClass().getClassLoader();
		// 动态构建一个代理站点
		IProxy iProxy = (IProxy) Proxy.newProxyInstance(loader, new Class[] { IProxy.class }, proxy);
		iProxy.buyTicket();
	}
}
