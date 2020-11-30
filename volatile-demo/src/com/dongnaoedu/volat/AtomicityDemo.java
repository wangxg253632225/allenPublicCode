package com.dongnaoedu.volat;

import java.util.concurrent.CountDownLatch;

/**
 * 发起20个线程，每个线程对count变量进行10000次自增操作，如果代码能够正确并发，
 * 则最终count的结果应为200000，但实际的运行结果却小于200000。
 * @author allen
 *
 */
public class AtomicityDemo {

	static volatile int count = 0;

	public static void increase() {
		count++;
	}

	public static void main(String[] args) {
		int threads = 20;
		CountDownLatch cdl = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						AtomicityDemo.increase();
					}
					cdl.countDown();
				}
			}).start();
		}

		try {
			cdl.await();	// 主线程等待所有线程执行完
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(AtomicityDemo.count);
	}
}
