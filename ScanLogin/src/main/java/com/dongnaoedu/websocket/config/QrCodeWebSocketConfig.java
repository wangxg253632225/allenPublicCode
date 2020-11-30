package com.dongnaoedu.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.Session;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 实现接口来配置Websocket请求的路径和拦截器
 * 
 * @see https://blog.csdn.net/Ouyzc/article/details/79994401
 * 
 * @author allen
 */
@Configuration		//注解标识该类为Spring的配置类
@EnableWebSocket	//开启注解接收和发送消息
@EnableScheduling
@EnableWebSocketMessageBroker
public class QrCodeWebSocketConfig extends AbstractSessionWebSocketMessageBrokerConfigurer<Session> implements WebSocketConfigurer {

	@Autowired
	private QrCodeWebSocketHandler handler;
	@Autowired
	private QrCodeWebSocketInterceptor interceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// handler是webSocket的核心，配置入口
		registry.addHandler(handler, "/qrcode/{uuid}").addInterceptors(interceptor).setAllowedOrigins("*");
		
		// registry.addHandler(endPoint, "/sockjs.do").addInterceptors(interceptor).setAllowedOrigins("*").withSockJS();
	}

	@Override
	protected void configureStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/messages").withSockJS();
	}

}
