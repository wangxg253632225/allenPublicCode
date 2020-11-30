<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<head>
	<title>登录</title>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style-head.css">		
	<!-- 
	<style class="blockbyte-bs-style" data-name="content">
		body>div#blockbyte-bs-indicator>div{opacity:0;pointer-events:none}body>iframe#blockbyte-bs-sidebar.blockbyte-bs-visible,body>iframe#blockbyte-bs-overlay.blockbyte-bs-visible{opacity:1;pointer-events:auto}body.blockbyte-bs-noscroll{overflow:hidden !important}body>div#blockbyte-bs-indicator>div{position:absolute;transform:translate3d(-40px, 0, 0);top:0;left:0;width:40px !important;height:100%;background:rgba(0,0,0,0.5);border-radius:0 10px 10px 0;transition:opacity 0.3s, transform 0.3s;z-index:2}body>div#blockbyte-bs-indicator>div>span{-webkit-mask:no-repeat center/32px;-webkit-mask-image:url(chrome-extension://jdbnofccmhefkmjbkkdkfiicjkgofkdh/img/icon-bookmark.svg);background-color:#ffffff;position:absolute;display:block;top:0;left:0;width:100%;height:100%}body>div#blockbyte-bs-indicator[data-pos='right']{left:auto;right:0}body>div#blockbyte-bs-indicator[data-pos='right']>div{transform:translate3d(40px, 0, 0);left:auto;right:0;border-radius:10px 0 0 10px}body>div#blockbyte-bs-indicator.blockbyte-bs-fullHeight>div{border-radius:0}body>div#blockbyte-bs-indicator.blockbyte-bs-hover>div{transform:translate3d(0, 0, 0);opacity:1}body>div#blockbyte-bs-indicator[data-pos='left'].blockbyte-bs-has-lsb{height:100% !important;top:0 !important}body>div#blockbyte-bs-indicator[data-pos='left'].blockbyte-bs-has-lsb>div{background:transparent}body>div#blockbyte-bs-indicator[data-pos='left'].blockbyte-bs-has-lsb>div>span{-webkit-mask-position-y:20px}body>iframe#blockbyte-bs-sidebar{width:350px;max-width:none;height:0;z-index:2147483646;background-color:rgba(0,0,0,0.6) !important;border:none;display:block !important;transform:translate3d(-350px, 0, 0);transition:width 0s 0.3s, height 0s 0.3s, opacity 0.3s, transform 0.3s}body>iframe#blockbyte-bs-sidebar[data-pos='right']{left:auto;right:0;transform:translate3d(350px, 0, 0)}body>iframe#blockbyte-bs-sidebar.blockbyte-bs-visible{width:calc(100% + 350px);height:100%;transform:translate3d(0, 0, 0);transition:opacity 0.3s, transform 0.3s}body>iframe#blockbyte-bs-sidebar.blockbyte-bs-hideMask{background:none !important}body>iframe#blockbyte-bs-sidebar.blockbyte-bs-hideMask:not(.blockbyte-bs-hover){width:calc(350px + 50px)}body>iframe#blockbyte-bs-overlay{width:100%;max-width:none;height:100%;z-index:2147483647;border:none;background:rgba(0,0,0,0.5) !important;transition:opacity 0.3s}
	</style> -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>

<!-- 
<div id="header">
	
</div>
 -->
<div class="login-wrap">
	<div class="wrap clearfix">
		<div style="font-size: 20px;">本次请求处理的服务器的端口为：<%=request.getLocalPort() %></div>
		<div class="form-box fr loginV2" style="display:block;">
			<ul class="form-tab clearfix">
				<li class="tab-li cur"><a href="javascript:;" tjjj="passport.login_type.wixin_qrcode">扫码登录<i class="icon"></i></a></li>
				<li class="tab-li"><a href="javascript:;" tjjj="passport.login_type.login_name">账号登录</a></li>
			</ul>
			<div class="form-con">
				<div class="weixin-login" style="display: block;">
					<div class="wx-box clearfix">
						<a href="javascript:;" class="wx-img-box">
							<img class="wx-qrCode" src="" id="qrCodeImg">
						</a>
						<img src="${pageContext.request.contextPath}/static/images/wx-image.png" class="wx-image">
					</div>
					<p class="wx-text">扫一扫  快速登录</p>
					<p class="wx-help"><a href="javascript:;" class="help-a">如何使用？</a></p>
				</div>
				<div class="login-normal" style="display: none;">
					<form id="nameLoginForm" method="post" action="${pageContext.request.contextPath}/doLogin" autocomplete="off" onsubmit="return nameLoginCheck();">
						<div class="form-error" style="display: none;"><i></i><label class="text"></label></div>
						<input type="hidden" name="uuid" id="uuid">
						<dl class="clearfix">
							<dt>账户名：</dt>
							<dd><input type="text" name="username" id="normalUser" class="input-text" autocomplete="off"><span class="placeholder">用户名/邮箱/手机号</span></dd>
						</dl>
						<dl class="top1 clearfix">
							<dt>密<em></em>码：</dt>
							<dd><input type="password" name="password" id="normalPassword" class="input-text"><span class="placeholder">请输入密码</span></dd>
						</dl>
						<div class="form-remember">
							<input name="rememberName" type="checkbox" id="remUser" class="rem-check" style="display:none;" checked="checked">
							<span class="rem-box rem-box-r memCheck"><input name="rememberMe" type="checkbox" id="remLogin" class="rem-check">三个月之内免登录</span> 
						</div>
						<div class="btn-box clearfix">
							<input id="normalSubmit" class="btn-settlement" type="submit" value="登    录" tjjj="passport.button.login">
						</div>
						<div class="link-box clearfix">
                            <a href="javascript:;" class="register" tjjj="passport.login.fstreg">新用户注册</a>
                            <a href="javascript:;" class="forget-pass" tjjj="passport.forget.password">忘记密码？</a>
                        </div>
					</form>
					<div class="login-short clearfix">
					   <div class="short-left">
							<h3>使用合作账号登录：</h3>
							<ul class="clearfix">
								<li class="qq"><a a="" href="javascript:;" tjjj="passport.login.thd.login.qq"></a></li>
								<li class="sina"><a href="javascript:;" tjjj="passport.login.thd.login.sina"></a></li>
								<li class="weixin"><a href="javascript:;" tjjj="passport.login.thd.login.weixin"></a></li>
							</ul>
						</div>
					   <div class="short-right">
                            <h3>您还可以选择：</h3>
                            <p class="phone-short clearfix">
                                <i class="phone"></i>
                                <a href="javascript:;" tjjj="" class="txt phoneLogin">手机快捷登录</a>
                            </p>
                       </div>
					</div>
				</div>
			</div>
		</div>
		<!-- -快捷登录 -->	
		<div class="form-box fr shortLogin" style="display:none;">
			<h5 class="title">快捷登录</h5>
         	<div class="form-con">
			<form id="mobileLoginForm" method="post" onsubmit="return mobileLoginCheck();">
				<div class="form-error" style="display: none;"><i></i><label class="text"></label></div>
				<dl class="clearfix">
					<dt>手机号：</dt>
					<dd><input name="mobile" type="text" id="partnerPhone" autocomplete="off" class="input-text mobile" maxlength="11" onblur="mobileCheck(this);"><span class="placeholder">请输入手机号</span></dd>
				</dl>
				<dl class="top1 clearfix">
					<dt>验证码：</dt>
					<dd>
						<input name="smsCaptcha" type="text" id="partnerYzm" class="input-yzm" onblur="captchCheck(this);" maxlength="4" autocomplete="off">
						<span class="span-yzm">
							<img id="smsCaptchaImage" src="${pageContext.request.contextPath}/static/images/code.jpg" title="点击图片刷新校验码" alt="点击图片刷新校验码" onclick="">
							<a href="javascript:changeCode(&#39;smsCaptchaImage&#39;,&#39;partnerYzm&#39;);" class="forget-pass">换一张</a>
						</span>
					</dd>
				</dl>
				<dl class="top2 clearfix">
					<dt>校验码：</dt>
					<dd>
						<input name="code" type="text" id="partnerJym" class="input-jym" maxlength="6" autocomplete="off">
						<a id="smsSendButton" href="javascript:sendSms(this);" class="span-jym disabled" tjjj="passport.send.msg">发送短信校验码</a>
					</dd>
				</dl>
				<div class="form-remember">
					<input name="rememberName" type="checkbox" id="remUser2" class="rem-check" style="display:none;" checked="checked">
					<span class="rem-box rem-box-r"><input name="rememberMe2" type="checkbox" id="remLogin2" class="rem-check">三个月之内免登录</span> 
				</div>
				<div class="btn-box clearfix">
					<input id="partnerSubmit" class="btn-settlement" type="submit" value="登    录" tjjj="passport.quick.button.login">
				</div>
				<div class="link-box clearfix">
                	<a href="javascript:;" class="backLogin">返回账号登录&gt;&gt;</a>
              	</div>
			</form>
			</div>
		</div>
	</div>
</div>

<div id="jia_footer">
    <div class="jia_foot_info">
        <div class="jia_foot_con">
            <p class="jia_foot_link">
                <a href="https://www.dongnaoedu.com/about/about.html" target="_blank" rel="nofollow">简介</a>
                <span class="jia_split">|</span> 
                <a href="http://www.sucaihuo.com/" target="_blank" rel="nofollow">联系我们</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com/about/join-us.html" target="_blank">加入我们</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com/about/student.html" target="_blank">学员风采</a>
                <span class="jia_split">|</span> 
                <a href="https://dongnao.ke.qq.com/#tab=0&amp;category=14687419363213503" target="_blank">腾讯课堂</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com/about/media.html" target="_blank">媒体合作</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com/about/company.html" target="_blank">企业合作</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com/about/answer.html" target="_blank">常见问题</a>
                <span class="jia_split">|</span> 
                <a href="https://www.dongnaoedu.com" target="_blank">更多<i></i></a>
            </p>
            <p class="jia_foot_link footnone">
                
            </p>
        </div>
        <p>Copyright©2013-2017 dongnaoedu.com  All Rights Reserved. 版权所有 2008-2017 湘ICP备16006411号-1 </p>
        <p>
            <a target="_blank" href="https://www.dongnaoedu.com/img/yyzz-20171121145209.jpg">湖南动脑信息科技有限公司 91430100MA4L21R090 </a>
        </p>
        <p>
            <a href="https://www.pinpaibao.com.cn/smyz/"><img src="${pageContext.request.contextPath}/static/images/1(1).png"></a>
            <a href="https://www.kxnet.cn/"><img src="${pageContext.request.contextPath}/static/images/2(1).png"></a>
        </p>
    </div>
</div>

<script type="text/javascript">
var basePath = "${pageContext.request.contextPath}";
//alert(basePath);

//得到二维码
$(function get_qrcode(){
	$.ajax({
		url: basePath + '/get_qrcode',
		type:'POST',
		dataType:'JSON',
		success:function(data){
			var imgSrc="data:image/png;base64,"+data.base64;
			var uuid = data.uuid;
			//$("#uuid").val(uuid);
			$("#qrCodeImg").attr("src",imgSrc);
			//jquery的轮询函数
			//self.setInterval(function(){
			//	roll_poling(uuid);
			//},2000);
			roll_poling(uuid);
		}
	});
});

//轮询操作 token
function roll_poling(uuid){
	$.ajax({
		url: basePath + '/roll_poling',
		type:'POST',
		dataType:'JSON',
		data:{uuid:uuid},
		success:function(data){
			if( data == "success" ){
				// alert("login success");
				//window.location.href=basePath + "/main.jsp";
				window.location.href=basePath + "/doLogin";
			} else if ( data == "faild" ) {
				roll_poling(uuid);
				//alert("该二维码已经失效,请重新获取");
			} else {
				//roll_poling(uuid);
			}
		}
	});
}

var _wx_server_qr_code_count = 0;
var _wx_server_qr_code_loaded = false;
var _qr_code_limited = '';
var _qr_code_wait_time = 20;
var flashQrCodeWaitingTimer = null;
var getQrCodeStatusTimer = null;
var getQrCodeTimer = null;

function nameLoginCheck(){
	var loginName = $("#nameLoginForm").find("#normalUser").eq(0).val();
	var password = $("#nameLoginForm").find("#normalPassword").eq(0).val();
	if($(".tips ").is(":visible")){
		return false;
	}
	if(loginName == null  || loginName == ""){
		showError("请输入用户名");
		return false;
	}
	if(password == null  || password == ""){
		showError("请输入密码");
		return false;
	}
	return true;
}

//手机登陆验证
function mobileLoginCheck(){
	var mobile = $("#mobileLoginForm").find("#partnerPhone").eq(0).val();
	var captch = $("#mobileLoginForm").find("#partnerYzm").eq(0).val();
	var code = $("#mobileLoginForm").find("#partnerJym").eq(0).val();
	if(mobile == null || mobile == '' || !(_mobile_reg).test(mobile)){
		showError("请填写正确的手机号");
		return false;
	}
	if(captch == null || captch == "" || captch == undefined){
		showError("请填写验证码");
		return false;
	}
	if(code == null || code == ""){
		showError("请填写校验码");
		return false;
	}
	return true;
}

function mobileCheck(obj){
	if(!(_mobile_reg).test($("#partnerPhone").val())){
		showError("请填写正确的手机号");
		return;
	}else{
		closeError();
	}
}

//发送短信
function sendSms(obj){
	alert("信息已发送  www.dongnaoedu.com - 动脑学院");
}

function captchCheck(obj){
	if(!(_mobile_reg).test($("#partnerPhone").val())){
		showError("请填写正确的手机号");
		return;
	}
	var captch = $(obj).val();
	if(captch == '' || captch == null){
		showError("请填写验证码");
	}else{
		checkCaptch(captch,
					function(){
						if(!$("#smsSendButton").hasClass("sending")){
						 	$("#smsSendButton").removeClass("disabled");
						}
						 closeError();
					},function(){
						showError("验证码错误");
						 $("#smsSendButton").addClass("disabled");
					}
		);
	}
}

$(function(){
	$(".form-tab li").on("click",function(){
		var index = $(this).index();
		$(this).addClass("cur").siblings().removeClass("cur");
		$(".form-con>div").hide().eq(index).show();
		if(index == 0){
            $(".form-foot").hide();           
        }else{
            $(".form-foot").show();
        }
		$(".form-error").hide();
	});
	$(".weixin-login .help-a").hover(
		function(){
			$(".wx-img-box,.wx-image").stop();
			$(this).parents(".weixin-login").find(".wx-img-box").animate({"marginLeft":"15px"},300,function(){
				$(this).parents(".weixin-login").find(".wx-image").animate({"opacity":1},300);
			});
		},
		function(){
			$(".wx-img-box,.wx-image").stop();
			$(this).parents(".weixin-login").find(".wx-image").stop().animate({"opacity":0},300,function(){
				$(this).parents(".weixin-login").find(".wx-img-box").animate({"marginLeft":"110px"},300);
			});
		}
	);
});

$('.jia_foot_open').click(function(){
    $('.footnone').slideToggle();
    $(this).find('i').toggleClass('footnow');
});
$('.phoneLogin').click(function(){
    $('.loginV2').hide();
    $('.shortLogin').show();
    $('.form-error').hide();
});
$('.backLogin').click(function(){
	 $('.login-normal').show();
    $('.loginV2').show();
    $('.shortLogin').hide();
    $('.form-error').hide();
});
//开启错误提示
function showError(error){
	$(".form-error").find("label").html(error);
	$(".form-error").show();
}
</script>