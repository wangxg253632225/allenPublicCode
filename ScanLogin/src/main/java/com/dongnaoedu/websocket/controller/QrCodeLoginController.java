package com.dongnaoedu.websocket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  
  
/** 
 * 描述：控制层 
 * @author songfayuan 
 * 2017年8月8日下午5:29:41 
 */  
@Controller  
@RequestMapping("/qrcodelogin")  
public class QrCodeLoginController {  
  
    private Logger logger = LoggerFactory.getLogger(QrCodeLoginController.class);  
      
    /** 
     * 描述：PC获取二维码 
     * @param uuid 
     * @param request 
     * @param response 
     * @throws ServletException 
     * @throws IOException 
     * @author songfayuan 
     * 2017年8月11日上午9:04:43 
     */  
    @RequestMapping("/getLoginQrCode")  
    @ResponseBody  
    public void getLoginQrCode(String uuid, HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        //生成参数  
        //String uuid = generateUUID();  
        String host = request.getHeader("Host");  
        JSONObject data = new JSONObject();  
        data.put("code", 200);  
        data.put("msg", "获取二维码成功");  
        data.put("uuid", uuid);  
        data.put("host", host);  
        logger.info("【二维码内容】：{}",data);
          
    }  
      
    /** 
     * 描述：app确认请求处理 
     * @param uuid 
     * @param host 
     * @param userid 
     * @author songfayuan 
     * 2017年8月11日上午9:05:56 
     */  
    @RequestMapping("/sendCodeLoginInfo")  
    @ResponseBody  
    public void sendCodeLoginInfo(String uuid, String host, Integer userid) {  
        // 注册成功后 或 登录，需要同步账户信息，获取用户基本信息  
       
        JSONObject token = null;
        JSONObject object = new JSONObject();  
        object.put("code", 10086);  
        object.put("uuid", uuid);  
        object.put("userinfo", "");  
        object.put("token", token);  
        object.put("msg", "登录成功");  
//        this.webSocketHandler.forwardQrCode(object.toString());  
//        jmsSender.sendMessage(object.toString()); //采用ActiveMQ进行推送，也可以直接注入websocket进行发送  
    }  
    
    /** 
     * 描述：唯一标识符 
     * @return 
     * @author songfayuan 
     * 2017年8月11日上午9:06:12 
     */  
    public static String generateUUID() {  
        String uuid = UUID.randomUUID().toString();  
        uuid = uuid.replace("-", "");  
        Long currentTime = System.currentTimeMillis();  
        String currentDate = String.valueOf(currentTime);  
        return uuid + currentDate;  
    }
      
}  