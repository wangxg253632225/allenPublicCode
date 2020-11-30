package com.dongnaoedu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongnaoedu.common.ApiResult;
import com.dongnaoedu.common.Table;

/**
 * 简单版的登录控制,实际项目可以使用  Spring Security 或 shiro 框架
 */
@Controller
public class Login {

    @RequestMapping("/")
    public  String toIndex(){
        return "toLogin";
    }

    @RequestMapping("/login/toLogin")
    public  String toLogin(){
        return "toLogin";
    }

    @PostMapping("/login/doLogin")
    @ResponseBody
    public ApiResult doLogin(HttpServletRequest request){
                String name=request.getParameter("name");
                String password=request.getParameter("password");

                if(!Table.user.containsKey(name)){
                    return  ApiResult.fail("账户名不存在");
                }

                if (!Table.user.get(name).equals(password)){
                    return  ApiResult.fail("密码不正确");
                }

                request.getSession().setAttribute("name",name);
             return    ApiResult.success();
    }
}
