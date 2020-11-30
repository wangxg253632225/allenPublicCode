package com.dongnaoedu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * 展示Java7和Java8的编程格式
 * 
 * @author allen
 */
public class Java8Test {
	@Test
	public void test() {

		List<Integer> names1 = new ArrayList<Integer>();
		names1.add(9);
		names1.add(3);
		names1.add(6);
		names1.add(8);
		names1.add(0);

		List<Integer> names2 = new ArrayList<Integer>();
		names2.add(9);
		names2.add(3);
		names2.add(6);
		names2.add(8);
		names2.add(0);

		Java8Test tester = new Java8Test();
		System.out.println("使用 Java 7 语法: ");
		tester.sortUsingJava7(names1);
		System.out.println(names1);
		
		System.out.println("使用 Java 8 语法: ");

		tester.sortUsingJava8(names2);
		System.out.println(names2);
	}

	// 使用 java 7 排序
	private void sortUsingJava7(List<Integer> names) {
		Collections.sort(names, new Comparator<Integer>() {
			@Override
			public int compare(Integer s1, Integer s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// 使用 java 8 排序
	private void sortUsingJava8(List<Integer> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
	
	@Test
	public void test11() {
		List<String> list = Arrays.asList("a","b","c","d");
		list.forEach(System.out::println);
	}
}
