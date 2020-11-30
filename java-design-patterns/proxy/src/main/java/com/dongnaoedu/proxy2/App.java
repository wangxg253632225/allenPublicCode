package com.dongnaoedu.proxy2;

/**
 * 测试类 - 静态代理
 * 
 * @author allen
 * 
 */
public class App {

	public static void main(String[] args) {
		// 用户信息
		User user = new User();
		user.setCardCode("430488888888888888");
		user.setSex("男");
		user.setName("Allen老师");
		user.setHomeAddress("湖南省.长沙市.动脑学院");

		// 具体代理
		RealProxy realClient = new RealProxy(user);
		// realClient.setUser(user);

		// 代理对象，把目标对象传给代理对象，建立代理关系
		Proxy proxy = new Proxy(realClient);
		
		proxy.buyTicket();	// 执行的是代理的方法
	}
}
