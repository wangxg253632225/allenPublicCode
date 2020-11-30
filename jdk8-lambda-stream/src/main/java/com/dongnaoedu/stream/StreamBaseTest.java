package com.dongnaoedu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Stream 测试
 * 
 * @author allen
 */
public class StreamBaseTest {

	// 基本语法
	/***************************************************************/
	// 获取一个List中，元素不为null的个数
	@Test
	public void test1() {
		//Lists是Guava中的一个工具类
		List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
		
		long rs = nums.stream().filter(num -> num != null).count();
		System.out.println(rs);
		
//		int rss = 0;
//		for (Integer a : nums) {
//			if (a != null) {
//				rss ++;
//			}
//		}
//		System.out.println(rss);
	}
	/***************************************************************/
	
	// 1、得到stream
	@Test
	public void test2() {
		// 1.通过Stream接口的静态工厂方法（注意：Java8里接口可以带静态方法）
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		Stream<String> stringStream = Stream.of("taobao");
	}
	
	// 2.通过Collection接口的默认方法（默认方法：Default method，也是Java8中的一个新特性，就是接口中的一个带有实现的方法）–stream()，把一个Collection对象转换成Stream
	public interface Collection<E> extends Iterable<E> {
	      //其他方法省略
	     default Stream<E> stream() {
	          return StreamSupport.stream(spliterator(), false);
	     }
	}
	
	// 2、转换stream
	@Test
	public void test3() {
		Stream<List<Integer>> inputStream = Stream.of(
				Arrays.asList(1), 
				Arrays.asList(2, 3), 
				Arrays.asList(4, 5, 6)
			);
		Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
		// flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，
		// 最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
	}
	
	// 2、汇聚（Reduce）Stream
	@Test
	public void test4() {
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("ints sum is:" + ints.stream().count());
	}
	/***************************************************************/
	
	
	
	/***************************************************************/
	// 特点演示
	/***************************************************************/
	// stream不存储数据
	public void test5() {
		Stream<String> stream = Stream.generate(()->"user").limit(20);
	    stream.forEach(System.out::println);
	    stream.forEach(System.out::println);
	}
	// 延迟执行特性，在聚合操作之前都可以添加相应元素
	@Test
	public void test() {
		List<String> wordList = new ArrayList<String>() {
			{
	            add("tony");
	            add("mike");
	        }
	    };
	    Stream<String> words = wordList.stream();
	    wordList.add("allen");
	    long n = words.distinct().count();
	    System.out.println(n);
	}
}
