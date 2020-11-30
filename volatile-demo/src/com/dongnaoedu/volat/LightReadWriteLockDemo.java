package com.dongnaoedu.volat;

/**
 * 开销较低的读写锁策略 
 * 保证并发读到最新的值 
 * 通过对写加锁，保证线程安全
 */
public class LightReadWriteLockDemo {

	private volatile int value;

	// volatile保证读取到的是最新值
	public int getValue() {
		return value;
	}

	// synchronized来保证只有一个线程修改
	public synchronized int increment(int num) {
		return value -= num;
	}
	
	// 不能这样去重新设置
//	public synchronized void setValue(int num) {
//		value = num;
//	}
	
}
