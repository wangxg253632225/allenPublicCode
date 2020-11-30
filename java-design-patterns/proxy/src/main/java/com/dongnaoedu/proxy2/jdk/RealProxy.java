package com.dongnaoedu.proxy2.jdk;

/**
 * 具体代理买票
 */
public class RealProxy implements IProxy {

	private User user;

	public RealProxy() {
	}

	public RealProxy(User user) {
		this.user = user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void buyTicket() {
		// 具体实现逻辑
		if (user != null) {
			System.out.println("***********我要买票***********");
			System.out.println("信息如下：");
			System.out.println("姓名：" + user.getName());
			System.out.println("性别：" + user.getSex());
			System.out.println("身份证号：" + user.getCardCode());
			System.out.println("住址：" + user.getHomeAddress());

			System.out.println("***********信息已核对***********");
			System.out.println("出票成功：动车D2222次09车20A");
		}
	}
}
