package com.dongnaoedu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream 操作
 * 
 * @author allen
 */
public class StreamTest {

	// map：转换流，将一种类型的流转换为另外一种流
	@Test
	public void test1() {
		String[] arr = new String[] { "yes", "YES", "no", "NO" };
		Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
	}

	// filter：过滤流，过滤流中的元素
	@Test
	public void test2() {
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.stream(arr).filter(x -> x > 3 && x < 8).forEach(System.out::println);
		// Arrays.stream(arr) 创建stream流
		// 方法体：filter(x -> x > 3 && x < 8) 传如lambda 变量x > 3 && x < 8  = 新stream
		// 所有满足条件的数据print
	}

	// flapMap：拆解流，将流中每一个元素拆解成一个流
	@Test
	public void test3() {
		String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "e", "f", "c", "d" };
		String[] arr3 = { "h", "j", "c", "d" };
		// Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
		Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
	}
	
	// sorted：对流进行排序
	@Test
	public void test4() {
		String[] arr1 = {"abc","a","bc","abcd"};
		/**
	     * 按照字符长度排序
	     */
	    Arrays.stream(arr1).sorted((x,y) -> {
	        if (x.length()>y.length())
	            return 1;
	        else if (x.length()<y.length())
	            return -1;
	        else
	            return 0;
	    }).forEach(System.out::println);
	    
	    Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}

	// Optional类型
	@Test
	public void test5() {
		List<String> list = new ArrayList<String>() {
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("add user3");
        opt.ifPresent(list::add);
        list.forEach(System.out::println);
	}
}
