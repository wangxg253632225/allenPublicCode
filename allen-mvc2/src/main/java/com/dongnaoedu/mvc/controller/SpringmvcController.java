package com.dongnaoedu.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongnaoedu.mvc.annotation.Controller;
import com.dongnaoedu.mvc.annotation.Quatifier;
import com.dongnaoedu.mvc.annotation.RequestMapping;
import com.dongnaoedu.mvc.service.MyService;
import com.dongnaoedu.mvc.service.SpringmvcService;

@Controller("wuqi")
public class SpringmvcController {
    @Quatifier("MyServiceImpl")
    MyService myService;
    @Quatifier("SpringmvcServiceImpl")
    SpringmvcService smService;

    @RequestMapping("insert")
    public void insert(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.insert(null);
        smService.insert(null);
        try {
			response.getWriter().write("insert method success");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.delete(null);
        smService.delete(null);
        return null;
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.update(null);
        smService.update(null);
        return null;
    }

    @RequestMapping("select")
    public String select(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.select(null);
        smService.select(null);
        return null;
    }
}