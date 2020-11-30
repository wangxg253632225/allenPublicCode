package com.dongnaoedu.rabbitmq.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send implements Runnable {
	private final CountDownLatch countDownLatch;
	// 队列名称
	private final static String QUEUE_NAME = "recvqueue";

	public Send(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		for (int i = 1000; i > 0; i--) {
			new Thread(new Send(countDownLatch)).start();
		}
		countDownLatch.countDown();
	}

	public void run() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 创建连接连接到MabbitMQ
		 */
		ConnectionFactory factory = new ConnectionFactory();
		// 设置MabbitMQ所在主机ip或者主机名
		factory.setHost("192.168.27.129");
		try {
			// 创建一个连接
			Connection connection = factory.newConnection();
			// 创建一个频道
			Channel channel = connection.createChannel();
			// 指定一个队列
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			// 发送的消息
			String message = "1";
			// 往队列中发出一条消息
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			// 关闭频道和连接
			channel.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
