package com.itstyle.jwt.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器  cookie认证
 */
public class CookieInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取request的cookie
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			System.out.println("没有cookie=============="); 
		} else {
			// 遍历cookie如果找到登录状态则返回true执行原来controller的方法
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("isLogin")) {
					return true;
				}
			}
		}
		// 没有找到登录状态则重定向到登录页，返回false，不执行原来controller的方法
		response.sendRedirect("/cookie/index");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
