package com.dongnaoedu.proxy2.extend;

import com.dongnaoedu.proxy2.IProxy;
import com.dongnaoedu.proxy2.User;

/**
 * 买飞机票
 * 
 * 具体代理买票 具体的代理对象，处理具体的业务逻辑
 * 
 * @author allen
 *
 */
public class RealProxy3 implements IProxy {

	private User user;

	public RealProxy3() {
		// ......
	}

	public RealProxy3(User user) {
		this.user = user;
	}

	/**
	 * 实现买票
	 */
	@Override
	public void buyTicket() {
		// 具体业务逻辑的实现
		if (user != null) {
			System.out.println("***********我要买飞机票***********");
			System.out.println("信息如下：");
			System.out.println("姓名：" + user.getName());
			System.out.println("性别：" + user.getSex());
			System.out.println("身份证号：" + user.getCardCode());
			System.out.println("住址：" + user.getHomeAddress());

			System.out.println("***********信息已核对***********");
			System.out.println("出票成功：国产C919次09车01A");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
