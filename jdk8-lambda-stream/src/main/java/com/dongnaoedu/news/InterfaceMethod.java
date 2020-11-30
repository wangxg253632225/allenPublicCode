package com.dongnaoedu.news;

/**
 * Java 8 默认方法
 * 
 * <pre>
 * 简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法
 * 我们只需在方法名前面加个default关键字即可实现默认方法
 * </pre>
 * 
 * @author allen
 *
 */
public interface InterfaceMethod {
	default void print(String name) {
		System.out.println("我是动脑学院["+name+"]老师......接口默认方法");
	}
}
