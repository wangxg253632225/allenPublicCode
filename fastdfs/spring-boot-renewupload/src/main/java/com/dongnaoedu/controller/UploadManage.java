package com.dongnaoedu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongnaoedu.common.ApiResult;
import com.dongnaoedu.common.ReadProper;
import com.dongnaoedu.common.RedisUtil;
import com.dongnaoedu.common.UpLoadConstant;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@Controller
@RequestMapping("/upload/Manage")
public class UploadManage {

	@Autowired
	private AppendFileStorageClient storageClient;

	@RequestMapping("/upload_list")
	public String upload_list(HttpServletRequest request) {
		// 从redis上获取已完成的文件,实际项目可以存储在mysql中,
		List<String> fileList = RedisUtil.getListAll(UpLoadConstant.completedList);
		List<JSONObject> jsonObjects = new ArrayList<>();
		if (CollUtil.isNotEmpty(fileList)) {
			for (String e : fileList) {
				JSONObject jsonObject = JSONUtil.parseObj(e);
				jsonObjects.add(jsonObject);

			}
		}
		request.setAttribute("fileServerUrl", ReadProper.getResourceValue("fileServerUrl"));
		request.setAttribute("fileList", jsonObjects);
		return "upload_list";
	}

	@RequestMapping("/toUpload")
	public String toUpload(HttpServletRequest request) {

		return "toUpload";
	}

	@PostMapping("/del")
	@ResponseBody
	public ApiResult doLogin(HttpServletRequest request, String md5) {
		// 模拟mysql文件表删除
		List<String> fileList = RedisUtil.getListAll(UpLoadConstant.completedList);
		List<JSONObject> jsonObjects = new ArrayList<>();
		int delindex = 0; // 删除索引
		String url = "";
		String value = "";
		if (CollUtil.isNotEmpty(fileList)) {
			for (String e : fileList) {
				JSONObject jsonObject = JSONUtil.parseObj(e);
				if (jsonObject.get("md5").equals(md5)) {
					url = (String) jsonObject.get("url");
					value = jsonObject.toString();
					break;
				}
				delindex++;
			}
		}
		storageClient.deleteFile(UpLoadConstant.DEFAULT_GROUP, url.replace(UpLoadConstant.DEFAULT_GROUP + "/", ""));
		RedisUtil.delListNode(UpLoadConstant.completedList, 1, value);
		return ApiResult.success();

	}

}
