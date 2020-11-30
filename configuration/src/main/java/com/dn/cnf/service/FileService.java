package com.dn.cnf.service;

import org.springframework.http.ResponseEntity;

public interface FileService {

    /**
     * 获取ftp的配置文件
     * @return
     */
    public ResponseEntity<String> getFTPProperties();
}
