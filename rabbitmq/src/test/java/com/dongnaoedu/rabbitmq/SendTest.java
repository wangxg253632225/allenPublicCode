package com.dongnaoedu.rabbitmq;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dongnaoedu.rabbitmq.mq.RabbitConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendTest {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Test
	public void sendMessage() {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		// 模拟300个并发请求
		for (int i = 0; i < 500; i++) {
			new Thread(new Send(countDownLatch)).start();
			;
		}

		// 计数器減一 所有线程释放 并发访问。
		countDownLatch.countDown();
	}

	private class Send implements Runnable {
		private final CountDownLatch countDownLatch;

		public Send(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			try {
				countDownLatch.await(); // 一直阻塞当前线程，直到计时器的值为0
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String message = "1";
			rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_ROUTING_KEY_recvqueue, message);
		}

	}

}
