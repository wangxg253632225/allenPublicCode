package com.dongnaoedu.proxy3.aop.set1;

public class Test {

	@org.junit.jupiter.api.Test
	public void test01() {
		// 从代理工厂中获得代理对象
		IMath math = (IMath) DynamicProxy.getProxy(new Math());
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
