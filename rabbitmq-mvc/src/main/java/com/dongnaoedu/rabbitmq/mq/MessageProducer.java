package com.dongnaoedu.rabbitmq.mq;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class MessageProducer {
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);  
 
    @Autowired 
    private AmqpTemplate amqpTemplate;  
 
    public void sendMessage(Object message) throws IOException {  
        logger.info("to send message:{}", message);  
        amqpTemplate.convertAndSend("sendqueueKey", message);  
    }  
}
