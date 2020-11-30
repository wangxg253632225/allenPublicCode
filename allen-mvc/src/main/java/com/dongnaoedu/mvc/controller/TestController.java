package com.dongnaoedu.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongnaoedu.mvc.annotation.MyController;
import com.dongnaoedu.mvc.annotation.MyQualifier;
import com.dongnaoedu.mvc.annotation.MyRequestMapping;
import com.dongnaoedu.mvc.annotation.MyRequestParam;
import com.dongnaoedu.mvc.service.TestService;

@MyController
@MyRequestMapping("/test")
public class TestController {
	
	@MyQualifier("testService")
	private TestService testService;
	
	@MyRequestMapping("/doTest")
	public void test1(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("param") String param) {
		System.out.println(param);
		
		// 尝试调用service中方法
		testService.insert(null);
		testService.delete(null);
		testService.update(null);
		testService.select(null);
		
		try {
			response.getWriter().write("doTest method success! param:" + param);
			//response.getWriter().print(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@MyRequestMapping("/doTest2")
	public void test2(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println("doTest2 method success!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
