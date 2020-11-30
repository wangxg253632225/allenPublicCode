package com.dongnaoedu.news;

import java.util.Arrays;
import java.util.List;

/**
 * Car类中定义了4个方法来区分Java中4种不同方法的引用
 * 
 * @author allen
 */
public class SupplierTest {
	
	// Supplier是jdk1.8的接口，这里和lamda一起使用了
	public static SupplierTest create(final Supplier<SupplierTest> supplier) {
		return supplier.get();
	}

	public static void collide(final SupplierTest car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final SupplierTest another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

	public static void main(String[] args) {
		// 构造器引用
		final SupplierTest car = SupplierTest.create(SupplierTest::new);
		final List<SupplierTest> cars = Arrays.asList(car);

		// 静态方法引用
		cars.forEach(SupplierTest::collide);

		// 特定类的任意对象的方法引用
		cars.forEach(SupplierTest::repair);

		// 特定对象的方法引用
		final SupplierTest police = SupplierTest.create(SupplierTest::new);
		cars.forEach(police::follow);
	}

}