package com.dongnaoedu.proxy2.extend;

import com.dongnaoedu.proxy2.Proxy;
import com.dongnaoedu.proxy2.RealProxy;
import com.dongnaoedu.proxy2.User;

/**
 * 测试类
 * 
 * @author allen
 * 
 */
public class App2 {

	public static void main(String[] args) {
		// 用户信息
		User user = new User();
		user.setCardCode("430488888888888888");
		user.setSex("男");
		user.setName("Allen老师");
		user.setHomeAddress("湖南省.长沙市.动脑学院");

		/*********************************************
		买火车票
		*********************************************/
		// 具体代理
		RealProxy2 realClient = new RealProxy2(user);
		// realClient.setUser(user);

		// 代理对象，把目标对象传给代理对象，建立代理关系
		Proxy2 proxy = new Proxy2(realClient);
		
		proxy.buyTicket();	// 执行的是代理的方法
		
		/*********************************************
		买飞机票
		*********************************************/
		// 具体代理
		RealProxy3 realClient3 = new RealProxy3(user);
		// realClient.setUser(user);

		// 代理对象，把目标对象传给代理对象，建立代理关系
		Proxy3 proxy3 = new Proxy3(realClient3);
		
		proxy3.buyTicket();	// 执行的是代理的方法
	}
}
