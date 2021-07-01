package com.kh.spring18.restcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring18.entity.StudentProfileDto;
import com.kh.spring18.repository.StudentProfileDao;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data/student")
@Slf4j
public class StudentDataController {
	
	@PostMapping("/upload")
	public void upload(@RequestParam MultipartFile f){
		if(!f.isEmpty()) {
			log.info("파일 업로드 완료");
			log.info("파일명 : {}", f.getOriginalFilename());
			log.info("파일크기 : {} bytes", f.getSize());
			log.info("파일유형 : {}", f.getContentType());
		}
	}
	
	@Autowired
	private StudentProfileDao studentProfileDao;
	
	@PostMapping("/upload2")
	public StudentProfileDto upload2(@RequestParam MultipartFile f) throws IllegalStateException, IOException {
		StudentProfileDto studentProfileDto = 
									StudentProfileDto
										.builder()
											.profileUploadName(f.getOriginalFilename())
											.profileContentType(f.getContentType())
											.profileSize(f.getSize())
										.build();
		StudentProfileDto result = studentProfileDao.add(studentProfileDto);
		studentProfileDao.save(studentProfileDto.getProfileSaveName(), f);
		return result;
	}
	
	@GetMapping("/download/{profileNo}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int profileNo) throws IOException {
		
		StudentProfileDto studentProfileDto = studentProfileDao.get(profileNo); 
		ByteArrayResource resource = studentProfileDao.getFile(studentProfileDto.getProfileSaveName());
		String fileName = URLEncoder.encode(studentProfileDto.getProfileUploadName(), "UTF-8");

		return ResponseEntity.ok()
								.contentType(MediaType.APPLICATION_OCTET_STREAM)
								.contentLength(studentProfileDto.getProfileSize())
								.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
								.header(HttpHeaders.CONTENT_DISPOSITION, 
										"attachment; filename=\""+fileName+"\"")
								.body(resource);
	}
	
}




