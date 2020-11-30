package com.dn.cnf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dn.cnf.service.FileService;

/**
 * 控制层
 */
@Controller
@RequestMapping("hrabbit")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * 将配置文件的json输出到浏览器
	 * @return
	 */
	@RequestMapping("/pos")
	public ResponseEntity<String> index() {
		return fileService.getFTPProperties();
	}
}
