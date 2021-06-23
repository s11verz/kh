package com.kh.spring11.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring11.entity.StudentProfileDto;
import com.kh.spring11.repository.StudentProfileDao;

@Controller
public class FileDownloadController {
	
	/**
	 *	다운로드
	 *	= 사용자에게 JSP 화면이 아닌 다른 무언가를 전달하는 것
	 *	= ViewResolver를 사용하면 안된다
	 *	= @ResponseBody 가 필요하다
	 *	= JSP/Servlet 처럼 직접 전송도 지원하지만 권장하지 않는다
	 *	= 식별 가능한 정보가 들어와야 파일을 읽어서 전송할 수 있다. 
	 */
	
	@Autowired
	private StudentProfileDao studentProfileDao;
	
	//JSP/Servlet 방식 : 응답객체를 이용하여 직접 응답을 생성하는 방식
	@GetMapping("/download1")
	public void download1(
			HttpServletResponse response, 
			@RequestParam int profileOrigin) throws IOException {
//		1. 파일 정보를 불러온다.
		StudentProfileDto studentProfileDto = studentProfileDao.getByOrigin(profileOrigin);
		 
//		2. 사용자에게 보낼 정보(header)를 설정한다.
//		response.setHeader("Content-Type", studentProfileDto.getProfileContentType());
//		response.setHeader("Content-Encoding", "UTF-8");
//		response.setHeader("Content-Length", String.valueOf(studentProfileDto.getProfileSize()));
//		response.setHeader("Content-Disposition", "attachment; filename=\""+URLEncoder.encode(studentProfileDto.getProfileUploadName(), "UTF-8")+"\"");
		
		response.setContentType(studentProfileDto.getProfileContentType());
		response.setCharacterEncoding("UTF-8");
		response.setContentLength((int)studentProfileDto.getProfileSize());
		response.setHeader("Content-Disposition", "attachment; filename=\""+URLEncoder.encode(studentProfileDto.getProfileUploadName(), "UTF-8")+"\"");
		
//		3. 파일을 불러와서 사용자에게 전송
		File target = new File("/Users/silverz/git/upload/student", studentProfileDto.getProfileSaveName());
		byte[] data = FileUtils.readFileToByteArray(target);
		response.getOutputStream().write(data);
	}
	
	//Spring 방식 : ResponseEntity라는 형태의 객체를 반환하도록 규정되어 있다.
	@GetMapping("/download2")
	public ResponseEntity<ByteArrayResource> download2(
				@RequestParam int profileOrigin
			) throws IOException{
		StudentProfileDto studentProfileDto = studentProfileDao.getByOrigin(profileOrigin);
		if(studentProfileDto == null) {
			return ResponseEntity.notFound().build();
		}
		
		File target = new File("D:/upload/student", studentProfileDto.getProfileSaveName());
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity.ok()
					.contentLength(studentProfileDto.getProfileSize())
					.header(HttpHeaders.CONTENT_TYPE, studentProfileDto.getProfileContentType())
					.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+URLEncoder.encode(studentProfileDto.getProfileUploadName(), "UTF-8")+"\"")
				.body(resource);
	}
	
	@GetMapping("/download3/{profileOrigin}")
	public ResponseEntity<ByteArrayResource> download3(
				@PathVariable int profileOrigin
			) throws IOException{
		StudentProfileDto studentProfileDto = studentProfileDao.getByOrigin(profileOrigin);
		if(studentProfileDto == null) {
			return ResponseEntity.notFound().build();
		}
		
		File target = new File("D:/upload/student", studentProfileDto.getProfileSaveName());
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity.ok()
					.contentLength(studentProfileDto.getProfileSize())
					.header(HttpHeaders.CONTENT_TYPE, studentProfileDto.getProfileContentType())
//					.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
					.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+URLEncoder.encode(studentProfileDto.getProfileUploadName(), "UTF-8")+"\"")
				.body(resource);
	}
}


