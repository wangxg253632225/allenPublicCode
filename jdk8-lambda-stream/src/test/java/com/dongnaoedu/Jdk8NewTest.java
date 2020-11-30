package com.dongnaoedu;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import com.dongnaoedu.news.InterfaceMethodImpl;
import com.dongnaoedu.news.InterfaceMethod;

/**
 * jdk8新特性测试
 * 
 * @author allen
 *
 */
public class Jdk8NewTest {

	// Java 8 方法引用
	@Test
	public void testMethod() {
		List<String> list = new ArrayList<String>();
		list.add("Tony");
		list.add("Mike");
		list.add("Allen");
		// 将 System.out::println 方法作为静态方法来引用
		list.forEach(System.out::println);
		// 1
//		for (String a : list) {
//			System.out.println(a);
//		}
		// 2
//		list.forEach(n -> System.out.println(n));
		// 3
//		list.forEach(System.out::println);
	}

	// Java 8 函数式接口
	@Test
	public void testFunctional() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Predicate<Integer> predicate = n -> true
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// n 如果存在则 test 方法返回 true
		System.out.println("输出所有数据:");
		// 传递参数 n
		eval(list, n -> true);

		// Predicate<Integer> predicate1 = n -> n%2 == 0
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// 如果 n%2 为 0 test 方法返回 true
		System.out.println("输出所有偶数:");
		eval(list, n -> n % 2 == 0);

		// Predicate<Integer> predicate2 = n -> n > 3
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// 如果 n 大于 3 test 方法返回 true
		System.out.println("输出大于 3 的所有数字:");
		eval(list, n -> n > 3);
	}

	// Predicate <T> 接口是一个函数式接口，它接受一个输入参数 T，返回一个布尔值结果
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}

	// Java 8 新增了接口的默认方法
	@Test
	public void testInterfaceMethod() {
		InterfaceMethod im = new InterfaceMethodImpl();
		im.print("Allen");
	}

	// Java 8 Optional 类
	// Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
	@Test
	public void testOptional() {
		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - 允许传递为 null 参数
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
		Optional<Integer> b = Optional.of(value2);

		System.out.println("第一个参数值存在: " + a.isPresent());
		System.out.println("第二个参数值存在: " + b.isPresent());
	}

	// Java 8 日期时间 API
	// Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理
	@Test
	public void testLocalDateTime() {
		// 获取当前的日期时间
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("当前时间: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

		// 解析字符串
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date2: " + date5);
	}

	// Java 8 Nashorn JavaScript
	// Java 中调用 JavaScript
	// 条用命令：js
	@Test
	public void testNashorn() {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "Aleln老师";
		Integer result = null;
		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		} catch (ScriptException e) {
			System.out.println("执行脚本错误: " + e.getMessage());
		}

		System.out.println(result.toString());
	}

	// Java8 Base64
	@Test
	public void testBase64() {
		try {
			// 使用基本编码
			String base64encodedString = Base64.getEncoder().encodeToString("allen讲java8新特性".getBytes("utf-8"));
			System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

			// 解码
			byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
			System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));

			base64encodedString = Base64.getUrlEncoder().encodeToString("allen?java8".getBytes("utf-8"));
			System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

		} catch (UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
}
