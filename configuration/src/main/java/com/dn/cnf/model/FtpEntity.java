package com.dn.cnf.model;

public class FtpEntity {
    //ftp服务器地址
    private String hostName;
    //ftp服务器端口号默认为21
    private String port;
    //ftp的用户名称
    private String userName;
    //ftp的密码
    private String passWord;
    //存储图片数据的根路径
    private String baseFile;
    //文件http服务器地址
    private String serverUrl;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBaseFile() {
        return baseFile;
    }

    public void setBaseFile(String baseFile) {
        this.baseFile = baseFile;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
