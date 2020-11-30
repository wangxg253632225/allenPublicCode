package com.dongnaoedu.proxy3.stc;

/**
 * 测试Math
 * 
 * @author allen
 *
 */
public class Test {

	IMath math= new MathProxy();
	
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
