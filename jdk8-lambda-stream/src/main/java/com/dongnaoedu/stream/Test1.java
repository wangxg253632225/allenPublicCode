package com.dongnaoedu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Test1 {

	// 取出一组集合中长度最长的字符串
	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		list.add("tony1");
		list.add("tony_1");
		list.add("mike");
		list.add("mike_1");
		list.add("allen_18");

		Optional<String> result = list.stream().max((x, y) -> x.length() - y.length());
		System.out.println(result.get());

		list.forEach(e -> System.out.print(e));
		list.forEach(System.out::print);
	}

	@Test
	public void test2() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		// 计算出来要循环多少次，和分页一样的原理
		final int limit = list.size() / 2 + 1;
		Stream.iterate(0, n -> n+1).limit(limit).parallel().forEach(a -> {
			List<String> spList = list.stream().skip(a * 2).limit(2).parallel().collect(Collectors.toList());
			System.out.println(spList.size());
		});
		
		List<List<String>> splitList = Stream.iterate(0, n -> n+1).limit(limit).parallel().map(a -> {
			return list.stream().skip(a * 2).limit(2).parallel().collect(Collectors.toList());
		}).collect(Collectors.toList());
	
		splitList.forEach(System.out::println); // 1 等价2
		
		for (List<String> ls : splitList) {		// 2 等价1
			System.out.println(ls.toString());
		}
		
	}
	
}
