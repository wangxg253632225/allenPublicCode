package com.dn.cnf.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dn.cnf.model.FtpEntity;
import com.dn.cnf.service.FileService;

/**
 * 业务层
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    //通过@Value注解去spring中读取配置文件
    @Value("${ftp.hostName}")
    private String hostName;
    //端口号
    @Value("${ftp.port}")
    private String port;
    //用户名称
    @Value("${ftp.userName}")
    private String userName;
    //ftp的密码
    @Value("${ftp.passWord}")
    private String passWord;
    //存储图片数据的根路径
    @Value("${ftp.baseFile}")
    private String baseFile;
    //文件http服务器地址
    @Value("${ftp.serverUrl}")
    private String serverUrl;

    /**
     * 获取配置文件
     * @return
     */
    public ResponseEntity<String> getFTPProperties(){
        try{
        	FtpEntity ftpProperties = new FtpEntity();
            ftpProperties.setHostName(hostName);
            ftpProperties.setBaseFile(baseFile);
            ftpProperties.setPassWord(passWord);
            ftpProperties.setPort(port);
            ftpProperties.setServerUrl(serverUrl);
            ftpProperties.setUserName(userName);
            return ResponseEntity.ok(JSONObject.toJSONString(ftpProperties));
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
