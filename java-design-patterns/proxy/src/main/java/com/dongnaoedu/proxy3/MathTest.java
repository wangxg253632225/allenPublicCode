package com.dongnaoedu.proxy3;

import org.junit.jupiter.api.Test;

/**
 * 测试Math
 * 
 * @author allen
 *
 */
public class MathTest {
	// math功能测试
	@Test
	public void test01() {
		Math math = new Math();
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}

	// math耗时测试
	@Test
	public void test02() {
		Math2 math = new Math2();
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
