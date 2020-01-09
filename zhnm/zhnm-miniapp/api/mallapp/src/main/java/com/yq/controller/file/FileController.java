package com.yq.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class FileController {
	Gson js = new Gson();
//	Logger log = Logger.getLogger(this.getClass());

	@ResponseBody
	@RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
	public String upload(@RequestParam MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String path = request.getSession().getServletContext().getRealPath("/")+"../mallupload"; 
			String fileName = new Date().getTime() + ".png";

			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			file.transferTo(targetFile);
			String url = "../mallupload/" + fileName;
			map.put("url", url);
			map.put("result", 1);
			// map.put("fileName", fileName);
		} catch (Exception e) {
			e.getStackTrace();
			map.put("result", 0);
			map.put("message", "上传图片出错！");
		}
		return js.toJson(map);
	}

	@ResponseBody
	@RequestMapping(value = "/app/image/upload", produces = "application/json;charset=UTF-8")
	public String appupload(@RequestParam MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String path = request.getSession().getServletContext().getRealPath("/")+"../mallupload"; 

		String fileName = new Date().getTime() + ".png";

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		file.transferTo(targetFile);
		String url = request.getContextPath() + "/../mallupload/" + fileName;
		map.put("url", url);
		map.put("result", 1);
//		log.info(js.toJson(map));
		return js.toJson(map);
	}
}
