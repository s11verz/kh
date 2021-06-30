package com.kh.spring18.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data/student")
@Slf4j
public class StudentDataController {

	@PostMapping("/upload")
	public void upload(@RequestParam MultipartFile f){
		if(!f.isEmpty()) {
			log.info("파일업로드 완료");
			log.info("파일명 : {}",f.getOriginalFilename());
			log.info("파일크기 : {} bytes",f.getSize());
			log.info("파일유형 : {}",f.getContentType());
		}
	}
}
