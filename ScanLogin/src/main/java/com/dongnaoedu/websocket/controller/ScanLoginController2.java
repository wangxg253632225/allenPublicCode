package com.dongnaoedu.websocket.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import com.dongnaoedu.poling.bean.User;
import com.dongnaoedu.websocket.config.QrCodeWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 扫描登录 二维码图片里包含的内容是一个uuid，手机端扫描后拿到uuid，将这个uuid作为参数向这个约定好的action发起请求
 * uuid，手机端登录用户的信息，服务端拿到后找到uuid这个key对应的value，将用户信息放进去。
 * 即http://nginx.xiaochunping.com/scan_login?uuid=123456&user=yuorfei
 * 
 * @author allen
 *
 */
@Controller
public class ScanLoginController2 {
	
	@Autowired
	private QrCodeWebSocketHandler handler;
	
	@RequestMapping("/scan_login2")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 手机端传来uuid和user信息
		String uuid = request.getParameter("uuid"); // token
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		// 该处模拟判断数据准确性，真实环境因该根据token和用户信息去查询
		if (username.equals("admin") && password.equals("admin")) {
			request.getSession().setAttribute("user", user);
			
			// websocket 扫码后得到数据，判断数据正确后发送通知告诉对应的客户端就行。和轮询方式不一样
			handler.sendUserMessage(uuid, new TextMessage(uuid));
		} 
	}
	
}
