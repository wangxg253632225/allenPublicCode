package com.dongnaoedu.poling.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongnaoedu.poling.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 浏览器翔服务端的轮询操作，判断是否有手机扫描了这个二维码 每次都向application里面查找uuid对应的value，
 * 不为空的时候取出用户信息处理就登录成功 为空的话就说明没有扫描过或者没有登录，继续轮询。
 * 
 * @author allen
 *
 */
@RestController
public class RollPolingController {

	@RequestMapping("/roll_poling")
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Thread.sleep(2000); // 轮询操作不要太快，休息两秒钟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 浏览器传来uuid
		String uuid = (String) request.getParameter("uuid");
		
		// spring seq shiro oauth2
		User user = (User) request.getServletContext().getAttribute(uuid);
		
		
		String message = "faild";
		if (user != null) {
			// user不为空说明扫描登录成功，做相应的处理即可
			message = "success";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(message);
		return result;
	}

}
