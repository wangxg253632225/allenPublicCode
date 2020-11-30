package com.itstyle.jwt.modules.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itstyle.jwt.common.entity.Response;
import com.itstyle.jwt.modules.user.model.User;
import com.itstyle.jwt.modules.user.repository.UserRepository;

@RestController
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response login(String username, String password, HttpServletRequest request) {
		User user = userRepository.findByUsername(username);
		// 验证账号密码，如果符合则改变session里的状态，并重定向到主页
		if (user != null) {
			if (user.getPassword().equals(password)) {
				request.getSession().setAttribute("isLogin", "yes");
				
				return Response.ok("session认证方式登录成功");
			} else {
				return Response.error("密码错误");
			}
		} else {
			return Response.error();
		}
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public Response index(String username) {
		User user = userRepository.findByUsername(username);
		return Response.ok(user.getDescription());
	}

	// 登出，移除登录状态并重定向的登录页
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public Response loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("isLogin");
		return Response.ok("session方式退出");
	}

}
