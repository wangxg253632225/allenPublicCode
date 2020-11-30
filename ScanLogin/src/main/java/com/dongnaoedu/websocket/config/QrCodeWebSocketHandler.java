package com.dongnaoedu.websocket.config;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSONObject;

@Component
public class QrCodeWebSocketHandler implements WebSocketHandler {
	private Logger log = LoggerFactory.getLogger(QrCodeWebSocketHandler.class);

	// 在线用户列表
	private static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

	private static Map<WebSocketSession, String> sessionMap2 = new ConcurrentHashMap<>();

	// 新增socket
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("WebSocketHandler:客户端{}上线", session.getRemoteAddress());
		
		String uuid = (String) session.getAttributes().get("WEBSOCKET_USERID");
		
		sessionMap.put(uuid, session);
		sessionMap2.put(session, uuid);
		//session.sendMessage(new TextMessage("成功建立socket连接"));
		log.info("当前在线人数：" + sessionMap.size());
	}

	// 接收socket信息
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String msg = (String) message.getPayload();
		// JSONObject requestData = JSON.parseObject(msg);
		String ipAddress = session.getRemoteAddress().toString();

		// Integer code = requestData.getInteger("code");
		JSONObject result = new JSONObject();
		String uuid = sessionMap2.get(session);
		result.put("code", 200);
		result.put("uuid", uuid);
		if (session.isOpen()) {
			session.sendMessage(new TextMessage(result.toString()));
			log.info("WebSocketHandler:客户端 {} 发送消息 :{}", ipAddress, msg);
		}
	}
	
	// 给所有人发信息
	public void sendAllUserMessage(TextMessage message) {
		sessionMap.forEach((k,v) -> {
			if (v.isOpen()) {
				try {
					v.sendMessage(new TextMessage(k));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 给指定人发信息
	public void sendUserMessage(String uuid, TextMessage message) {
		sessionMap.forEach((k,v) -> {
			if (k.equals(uuid)) {
				if (v.isOpen()) {
					try {
						v.sendMessage(new TextMessage(k));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	// 发送消息
	@Deprecated
	public void sendMessage(String userInfo) throws Exception {
		JSONObject json = JSONObject.parseObject(userInfo);
		String uuid = json.getString("uuid");
		WebSocketSession session = sessionMap.get(uuid);
		if (session == null) {
			log.info("app发送给PC的登录信息：{}参数不正确！", userInfo);
		} else {
			log.info("app发送给PC的登录信息：{}", userInfo);
			session.sendMessage(new TextMessage(userInfo));
		}
	}
	
	// 异常
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		log.info("WebSocketHandler:客户端{}异常", session.getRemoteAddress(), exception);
		sessionMap2.remove(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String ipAddress = session.getRemoteAddress().toString();
		log.info("WebSocketHandler:客户端{}下线", ipAddress);
		log.info("WebSocketHandler:删除客户端{}的session...", ipAddress);
		log.info("WebSocketHandler:删除sessionMap的客户端{}连接...", ipAddress);
		String uuid = sessionMap2.get(session);
		sessionMap.remove(uuid);
		sessionMap2.remove(session);
		log.info("WebSocketHandler:删除sessionMap的客户端{}连接完成", ipAddress);
		log.info("WebSocketHandler:删除WebSocket客户端{}连接...", ipAddress);
		// logger.info("{}", sessionMap);
		sessionMap.remove(session);
		// logger.info("{}", sessionMap);
		log.info("WebSocketHandler:删除WebSocket客户端{}连接完成", ipAddress);
		log.info("WebSocketHandler:删除客户端{}的session完成", ipAddress);
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}