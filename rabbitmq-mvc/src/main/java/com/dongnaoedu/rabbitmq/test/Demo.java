package com.dongnaoedu.rabbitmq.test;

import java.util.concurrent.CountDownLatch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 模拟下高并发下访问该服务
 * 
 * @author allen
 */
public class Demo implements Runnable {
	
	private final CountDownLatch countDownLatch;
	
	RestTemplate restTemplate = new RestTemplate();

	public Demo(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		try {
			countDownLatch.await();	//一直阻塞当前线程，直到计时器的值为0
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// do
		ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8081/rabbitmq-mvc/user/get/1",
				String.class);
		System.out.println(result);
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		for (int i = 800; i > 0; i--) {	//模拟300个并发请求
			new Thread(new Demo(countDownLatch)).start();
		}
		countDownLatch.countDown();	//计数器減一  所有线程释放 并发访问。
	}
}
