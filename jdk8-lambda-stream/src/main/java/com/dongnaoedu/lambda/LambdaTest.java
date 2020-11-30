package com.dongnaoedu.lambda;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Lambda表达式测试
 * 
 * @author allen
 *
 */
public class LambdaTest {

	// TreeSet中元素排序的方法（根据长度排序）– 匿名内部类
	/***********************************************************/
	@Test
	public void testSetSort() {
		// 使用匿名内部类作为参数传递
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		TreeSet<String> treeSet = new TreeSet<>(comparator);

		// 或者 Lambda 表达式作为参数传递
		TreeSet<String> treeSet1 = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
	}

	@Test
	public void testSetSort_lambda() {
		// 使用 Lambda 表达式作为参数传递
		Comparator<String> comparator = (x, y) -> Integer.compare(x.length(), y.length());
		TreeSet<String> treeSet = new TreeSet<>(comparator);
	}
	/***********************************************************/

	// 创建一个线程
	/***********************************************************/
	@Test
	public void testThread() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello word");
			}
		};
		runnable.run();
	}

	@Test
	public void testThread_lambda() {
		Runnable runnable2 = () -> System.out.println("hello word lambda");
		runnable2.run();
	}
	/***********************************************************/

}
