<%@page import ="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:set var="now" value="<%=new java.util.Date()%>" />
<title>首页</title>
</head>
<body>
	<h2> 
		您已经登录成功<br>
		您的用户名为：${user.username }<br>
		您的密码为：${user.password }<br>
	</h2>
       
<!-- 
	<h2>
		本次请求处理的服务器的端口为：<%=request.getLocalPort()%>
	</h2>
	
	<form action="doLogin.do">
		<input type="submit" value="刷新"></input>
	</form>
	<form action="logout.do">
		<input type="submit" value="登出"></input>
	</form>
 -->
</body>
</html>