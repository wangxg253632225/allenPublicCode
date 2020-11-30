package com.dongnaoedu.proxy2.cglib;

/**
 * 测试类 - cglib代理
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
		BuyTicket target = new BuyTicket(user);
		
		// 代理对象
		BuyTicket proxy = (BuyTicket) new ProxyFactory(target).getProxyInstance();
		
		// 执行代理对象的方法
		proxy.buyTicket();
	}
}
