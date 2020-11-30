<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>二维码登录</title>
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
	<img id="qrcode" src=""></img>
</body>

<script>
	var basePath = "${pageContext.request.contextPath}";
	// alert(basePath);
	//得到二维码
	function get_qrcode(){
		$.ajax({
			url: basePath + '/get_qrcode',
			type:'POST',
			dataType:'JSON',
			success:function(data){
				var imgSrc="data:image/png;base64,"+data.base64;
				var uuid = data.uuid;
				$("#qrcode").attr("src",imgSrc);
				//jquery的轮询函数
				self.setInterval(function(){
					roll_poling(uuid);
				},2000);
			}
		});
	}
	
	//轮询操作
	function roll_poling(uuid){
		$.ajax({
			url: basePath + '/roll_poling',
			type:'POST',
			dataType:'JSON',
			data:{uuid:uuid},
			success:function(data){
				if( data == "success" ){
					// alert("login success");
					window.location.href="http://www.baidu.com";
				}	
			}
		});
	}
	window.onload=get_qrcode();
</script>

</html>