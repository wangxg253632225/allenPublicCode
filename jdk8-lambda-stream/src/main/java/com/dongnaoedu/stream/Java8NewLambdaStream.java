package com.dongnaoedu.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Java8NewLambdaStream {

	@Test
	public void test() {
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd");
		
		list.forEach(System.out::println);
		
		// 使用stream输出10个随机数
		Random random = new Random();
		for (int i= 0; i<10; i++) {
			System.out.println(random.nextInt());
		}
		
		random.ints().limit(10).forEach(System.out::println);
		
		System.out.println(random.ints().limit(10).sum());
	}
	
	@Test
	public void test1() {
		// 获取对应平方数
		List<Integer> list = Arrays.asList(2, 3, 5, 1, 0, 7, 7);
		List<Integer> sList = list.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		List<Integer> sList2 = list.stream().map(i -> i*i).collect(Collectors.toList());
		sList.forEach(System.out::println);
		
		System.out.println("------------------");
		sList2.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd");
		
		// 使用lambda和stram找出list中空字符串个数
		int count = 0;
		for (String str : list) {
			if (str.equals("")) {
				count++;
			}
		}
		
		System.out.println(count);
		
		System.out.println("--------java8 stram 处理方式");
		long count1 = list.stream().filter(str -> str.isEmpty()).count();
		System.out.println(count1);
	}
	
	@Test
	public void test3() {
		Random random = new Random();
		
		IntStream is = random.ints().limit(10).sorted();
		
		is.forEach(System.out::println);
		
		//报错
//		is.limit(120);
		
//		System.out.println(is.sum());
		
		// 一个流只能使用一次
	}
	
}
