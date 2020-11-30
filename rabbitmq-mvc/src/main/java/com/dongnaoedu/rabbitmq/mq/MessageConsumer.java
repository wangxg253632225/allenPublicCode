package com.dongnaoedu.rabbitmq.mq;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.dongnaoedu.rabbitmq.model.User;
import com.dongnaoedu.rabbitmq.service.UserService;

public class MessageConsumer implements MessageListener {
	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);  
   
	@Autowired
    UserService userService;
    @Autowired
    MessageProducer messageProducer;
    
    public void onMessage(Message message) {
        logger.info("consumer receive message------->:{}", message); 
        User user = userService.getUser(new String(message.getBody()));
        try {
			messageProducer.sendMessage(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

}
