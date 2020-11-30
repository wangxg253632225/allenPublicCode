package com.dongnaoedu.lambda;

import java.util.Comparator;

import org.junit.Test;

/**
 * 变量作用域
 * 
 * @author allen
 */
public class Jdk8LambdaVariableTest {
	/***********************************************************/
	final static String salutation = "Hello! ";

	interface GreetingService {
		void sayMessage(String message);
	}
	
	@Test
	public void test1() {
		GreetingService greetService1 = message -> System.out.println(salutation + message);
		greetService1.sayMessage("Allen");
	}
	/***********************************************************/
	
	interface Converter<T1, T2> {
        void convert(int i);
    }
	
	@Test
	public void test2() {
		final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
	}
	/***********************************************************/
	
	@Test
	public void test3() {
//		int num = 1;  
//		Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
//		s.convert(2);
//		num = 5;  
		//报错信息：Local variable num defined in an enclosing scope must be final or effectively final
	}
	/***********************************************************/
	
	@Test
	public void test4() {
//		String first = "";  
//		Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错 
	}
	/***********************************************************/
}
