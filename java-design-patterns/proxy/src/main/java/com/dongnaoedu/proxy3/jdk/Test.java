package com.dongnaoedu.proxy3.jdk;

/**
 * 测试Math
 * 
 * @author allen
 *
 */
public class Test {

	//实例化一个MathProxy代理对象
	//通过getProxyObject方法获得被代理后的对象
	IMath math=(IMath)new DynamicProxy().getProxyObject(new Math());
	
	// 换成这样行不行？
//	Math math=(Math)new DynamicProxy().getProxyObject(new Math());
	
	// math耗时测试
	@org.junit.jupiter.api.Test
	public void test01() {
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
