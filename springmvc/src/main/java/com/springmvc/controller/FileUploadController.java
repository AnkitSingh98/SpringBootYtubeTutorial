package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springmvc.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	@PostMapping("/file-upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath());
		boolean isUploaded = fileUploadHelper.uploadFile(file);
		
		if(isUploaded)
		System.out.println("Image Uploaded");
		if(isUploaded)
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString();
		else
			return "Failed";
	}

}
