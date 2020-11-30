package com.dongnaoedu.proxy3.aop.set0;

import org.springframework.aop.framework.ProxyFactory;

import com.dongnaoedu.proxy3.aop.advice.AfterAdvice;
import com.dongnaoedu.proxy3.aop.advice.BeforeAdvice;
import com.dongnaoedu.proxy3.aop.advice.SurroundAdvice;
import com.dongnaoedu.proxy3.aop.set1.IMath;
import com.dongnaoedu.proxy3.aop.set1.Math;

public class Test {
	@org.junit.jupiter.api.Test
	public void test01() {
		// 实例化Spring代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 设置被代理的对象
		factory.setTarget(new Math());
		// 添加通知，横切逻辑
		factory.addAdvice(new BeforeAdvice());
		factory.addAdvice(new AfterAdvice());
		factory.addAdvice(new SurroundAdvice());
		// 从代理工厂中获得代理对象
		IMath math = (IMath) factory.getProxy();
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
}
