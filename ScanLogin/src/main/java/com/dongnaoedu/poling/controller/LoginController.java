package com.dongnaoedu.poling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongnaoedu.poling.bean.User;

@Controller
public class LoginController {

	// 返回登录页面
	@RequestMapping("/")
	public String login(String type) {
		return "login";
		
		// websocket实现
		//return "login2";
	}

	// 展示首页
	@RequestMapping("/doLogin")
	public String doLogin(String username, String password, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		
		String uuid = request.getParameter("uuid");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//request.getServletContext().setAttribute(uuid, user);
		//httpSession.setAttribute(uuid, user);

		return "main";
	}

	// 登出后，返回登录页面
	@RequestMapping("logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

}
