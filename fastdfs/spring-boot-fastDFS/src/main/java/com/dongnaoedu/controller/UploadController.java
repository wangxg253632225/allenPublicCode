package com.dongnaoedu.controller;

import java.io.IOException;
import java.io.InputStream;

import org.csource.fastdfs.ProtoCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongnaoedu.fastdfs.FastDFSClient;
import com.dongnaoedu.fastdfs.FastDFSFile;

/**
 * 文件下载 - fastdfs
 * 
 * @author allen
 *
 */
@Controller
public class UploadController {
	private static Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	 public static void main(String[] args) {
		 try {
			int lts = (int) (System.currentTimeMillis()/1000L);
			String remoteFilename = "M00/00/00/wKhkZluOiqqAEaMDAAKb7EaMLHk929.jpg";
			System.out.println("lts="+lts);
			String token = ProtoCommon.getToken(remoteFilename, lts, "FastDFS1234567890");
			System.out.println("token="+token);
			System.out.println("http://192.168.100.102/group1/"+remoteFilename+"?token="+token+"&ts="+lts);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload") // new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// Get the file and save it somewhere
			String path = saveFile(file);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
			redirectAttributes.addFlashAttribute("path", path);
		} catch (Exception e) {
			logger.error("upload file failed", e);
		}
		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	/**
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public String saveFile(MultipartFile multipartFile) throws IOException {
		String[] fileAbsolutePath = {};
		String fileName = multipartFile.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		byte[] file_buff = null;
		InputStream inputStream = multipartFile.getInputStream();
		if (inputStream != null) {
			int len1 = inputStream.available();
			file_buff = new byte[len1];
			inputStream.read(file_buff);
		}
		inputStream.close();
		FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
		try {
			fileAbsolutePath = FastDFSClient.upload(file); // upload to fastdfs
		} catch (Exception e) {
			logger.error("upload file Exception!", e);
		}
		if (fileAbsolutePath == null) {
			logger.error("upload file failed,please upload again!");
		}
		// String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
		String path = fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
		return path;
	}
}