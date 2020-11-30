package com.dongnaoedu.proxy3.aop.set2;

public class Test {

	@org.junit.jupiter.api.Test
	public void test01() {
		Math math = new SpringProxy<Math>().getProxyObject(new Math());
		int n1 = 999, n2 = 112;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.div(n1, n2);
	}
}
