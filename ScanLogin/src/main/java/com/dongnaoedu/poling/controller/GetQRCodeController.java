package com.dongnaoedu.poling.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongnaoedu.poling.bean.User;
import com.dongnaoedu.poling.util.QRCodeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 得到二维码 这里得到二维码的图片是传递的base64编码，便于在传递图片的同时也可以将参数传递过去。 前端解析base64很简单，谷歌会告诉你
 */
@RestController
public class GetQRCodeController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/get_qrcode")
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 生成uuid，传给客户端，同时二维码里的内容也是这个uuid
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		String base64 = QRCodeUtil.toBase64(uuid, 200, 200);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("uuid", uuid);
		hashMap.put("base64", base64);
		
		redisTemplate.opsForHash().putAll(uuid, hashMap);
		// 2分钟超时
		redisTemplate.expire(uuid, 2, TimeUnit.MINUTES);
		
		// 使用jackson
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(hashMap);
		
		// 目前UUID对应的用户是空的，手机扫描后往这个uuid对应的user放入相应的cookie或者登录信息，这样轮询的时候就能拿到这些登录信息
		// 如果不能使用application等会话，可以使用缓存，uuid做key，user为value。
		User user = null;
		request.getServletContext().setAttribute(uuid, user);
//		redisTemplate.opsForValue().set(uuid, user);
		// 2分钟超时
//		redisTemplate.expire(uuid, 2, TimeUnit.MINUTES);
		return result;
	}

}
