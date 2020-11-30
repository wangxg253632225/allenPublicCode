package com.dongnao.sessdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 演示本地tomcat sessin机制
 * 
 * @author allen
 */
@Controller
public class SessionController {

	@RequestMapping("/session")
	@ResponseBody
	public String sessionTrack(HttpServletRequest request) {
		
		//这段代码取消，是不会创建session
		//jsp 九大内置对象， session对象 jsp默认，
		//HttpSession session = request.getSession();
		
		//session.setAttribute("names", "Toney Mike Allen");
		
		return "动脑学院三大帅哥...【Toney Mike Allen】";
		
	}
}
