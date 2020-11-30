package com.dongnaoedu.news;

/**
 * java 8 方法引用
 * 
 * <pre>
 * 方法引用通过方法的名字来指向一个方法
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码
 * 方法引用使用一对冒号 ::
 * </pre>
 * 
 * @author allen
 *
 * @param <T>
 */
// @FunctionalInterface标记在接口上，“函数式接口”是指仅仅只包含一个抽象方法的接口
@FunctionalInterface
public interface Supplier<T> {
	// 抽象方法
	T get();

	// java.lang.Object中的方法不是抽象方法
	public boolean equals(Object obj);

	// default不是抽象方法
	public default void defaultMethod() {}

	// static不是抽象方法
	public static void staticMethod() {}
	
}