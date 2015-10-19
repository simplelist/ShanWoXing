package com.yxtar.server.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yxtar.server.util.AliyunOssUtils;




/**
 * Upload Controller
 * @author jimmylo
 * 
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	private AliyunOssUtils aliyunOss;

	/**
	 * 图片上传
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	@RequestMapping(value = "/img", method = RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute Object object, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException,MaxUploadSizeExceededException {

		MultipartHttpServletRequest request1 =(MultipartHttpServletRequest)request;
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		FileItemFactory factory = new DiskFileItemFactory();

		List<MultipartFile> items = null;
		List<String> stringTime = new ArrayList<String>();
		try {
			items = request1.getFiles("uploadFormElement");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				try {
					MultipartFile item = (MultipartFile) iter.next();

					//process the key name by time
					Calendar calendar = Calendar.getInstance();
					String time = String.valueOf(calendar.getTimeInMillis());
					if (stringTime.size() == 0) {
						stringTime.add(time);
					} else {
						String times = null;
						for (int j = 0; j < stringTime.size(); j++) {
							times = check(stringTime.get(j));
						}
						stringTime.add(times);
						time = times;
					}
					
					int index = item.getOriginalFilename().lastIndexOf(".");
					// 获得文件扩展名
					String xx = item.getOriginalFilename().substring(index, item.getOriginalFilename().length());
					String key = time + xx;

					//upload to Aliyun Oss
					aliyunOss.multipartUpload(key, item);

					response.setStatus(HttpServletResponse.SC_CREATED);
					response.flushBuffer();

				} catch (Exception e) {

					response.getWriter().print(",Fail:{" + e.getMessage() + "},");
					e.printStackTrace();
					continue;
				}

			}
		} catch (Exception e) {
			response.getWriter().print("Fail:{0}");
			e.printStackTrace();
		}

		return null;
	}


	public String check(String name) {
		Calendar calendar = Calendar.getInstance();
		while (String.valueOf(calendar.getTimeInMillis()).equals(name)) {
			name = String.valueOf(calendar.getTimeInMillis());
		}
		return name;
	}


}
