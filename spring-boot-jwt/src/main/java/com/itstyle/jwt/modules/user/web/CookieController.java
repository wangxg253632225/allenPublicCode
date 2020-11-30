package com.itstyle.jwt.modules.user.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itstyle.jwt.common.entity.Response;
import com.itstyle.jwt.modules.user.model.User;
import com.itstyle.jwt.modules.user.repository.UserRepository;

@RestController
@RequestMapping("/cookie")
public class CookieController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response login(String username, String password, HttpServletResponse response) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				Cookie cookie = new Cookie("isLogin", "yes");
				cookie.setMaxAge(30 * 60);// 设置为30min
				cookie.setPath("/");
				response.addCookie(cookie);
				
				return Response.ok("cookie认证方式登录成功");
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

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public Response loginOut(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("isLogin")) {
				cookie.setValue(null);
				cookie.setMaxAge(0);// 立即销毁cookie
				cookie.setPath("/");
				response.addCookie(cookie);
				break;
			}
		}
		return Response.ok("cookie方式退出");
	}

}
