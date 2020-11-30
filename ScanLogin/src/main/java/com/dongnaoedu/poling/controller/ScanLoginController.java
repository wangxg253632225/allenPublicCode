package com.dongnaoedu.poling.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongnaoedu.poling.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 扫描登录 二维码图片里包含的内容是一个uuid，手机端扫描后拿到uuid，将这个uuid作为参数向这个约定好的action发起请求
 * uuid，手机端登录用户的信息，服务端拿到后找到uuid这个key对应的value，将用户信息放进去。
 * 即http://nginx.xiaochunping.com/scan_login?uuid=123456&user=yuorfei
 * 
 * @author allen
 *
 */
@RestController
public class ScanLoginController {
	
	@RequestMapping("/scan_login")
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 手机端传来uuid和user信息
		String uuid = request.getParameter("uuid"); // token
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		request.getServletContext().setAttribute(uuid, user);
		request.getServletContext().setAttribute("user", user);
		request.getSession().setAttribute("user", user);
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString("success");
		return result;
	}
	
}
