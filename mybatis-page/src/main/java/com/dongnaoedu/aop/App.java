package com.dongnaoedu.aop;

import org.springframework.aop.framework.ProxyFactory;

public class App {

	public static void main(String[] args) {
		// 用户信息
		User user = new User();
		user.setCardCode("430488888888888888");
		user.setSex("男");
		user.setName("Allen老师");
		user.setHomeAddress("湖南省.长沙市.动脑学院");
		
		// 实例化Spring代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 设置被代理的对象
		factory.setTarget(new BuyTicket(user));
		// 添加通知，横切逻辑
		factory.addAdvice(new BeforeAdvice());
		factory.addAdvice(new AfterAdvice());
		factory.addAdvice(new SurroundAdvice());
		// 从代理工厂中获得代理对象
		IProxy proxy = (IProxy) factory.getProxy();
		proxy.buyTicket();
	}

}