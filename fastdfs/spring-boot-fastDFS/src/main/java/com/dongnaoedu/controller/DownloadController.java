package com.dongnaoedu.controller;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.csource.fastdfs.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongnaoedu.fastdfs.FastDFSClient;

/**
 * 文件操作(下载，获取信息，删除) - fastdfs
 * 
 * @author allen
 *
 */
@Controller
public class DownloadController {

	/**
	 * 文件下载
	 * 
	 * @param fileName
	 * @param response
	 * @param redirectAttributes
	 * @throws Exception
	 */
	@RequestMapping(value = "download")  
	public void downloadFile(String fileName, HttpServletResponse response, RedirectAttributes redirectAttributes) {  
		String group = fileName.substring(0, 6);
		String fn = fileName.substring(fileName.substring(0, 6).length()+1, fileName.length());
		
		InputStream is = FastDFSClient.downFile(group, fn);
		try {
			response.reset(); 
			response.setContentType("application/force-download");// 设置强制下载不打开
			// 设置下载文件名
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fn, "UTF-8") + "\"");  
		    response.setContentType("application/octet-stream;charset=UTF-8");
		    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
		    byte[] buffer = new byte[1024];
			int i = is.read(buffer);
			while (i != -1) {
				outputStream.write(buffer, 0, i);
				i = is.read(buffer);
			}
			is.close();
		    outputStream.flush();  
		    outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取文件名称
	 * 
	 * @param fileName
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("getFile")
	public String getFileInfo(String fileName, RedirectAttributes redirectAttributes) {
		String group = fileName.substring(0, 6);
		String fn = fileName.substring(fileName.substring(0, 6).length()+1, fileName.length());
		FileInfo fileInfo = null;
		try {
			fileInfo = FastDFSClient.getFile(group, fn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "获取文件信息 ；文件大小：" + fileInfo.getFileSize() + ",文件来源地址："
				+ fileInfo.getSourceIpAddr() + ",创建时间：" + fileInfo.getCreateTimestamp());
		return "redirect:/uploadStatus";
	}
	
	/**
	 * 删除文件
	 * 
	 * @param fileName
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("delete")
	public String deleteFile(String fileName, RedirectAttributes redirectAttributes) {
		String group = fileName.substring(0, 6);
		String fn = fileName.substring(fileName.substring(0, 6).length()+1, fileName.length());
		try {
			FastDFSClient.deleteFile(group, fn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "删除成功 " + fileName);
		return "redirect:/uploadStatus";
	}
	
}