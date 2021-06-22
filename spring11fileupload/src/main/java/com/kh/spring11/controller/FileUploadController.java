package com.kh.spring11.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.entity.StudentVO;
import com.kh.spring11.service.StudentService;

@Controller
public class FileUploadController {
	
	@GetMapping("/upload")
	public String upload() {
		//return "/WEB-INF/views/upload.jsp";
		return "upload";
	}
	
	/**
	 *	Spring에서는 파일을 MultipartFile 이라는 형태로 수신한다.
	 *	= MultipartResolver가 등록되어 있어야 수신 가능 
	 *	= cos.jar와는 다르게 먼저 저장을 하지 않고 명령을 통해 저장
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	@PostMapping("/upload1")
	public String upload1(@RequestParam MultipartFile f) throws IllegalStateException, IOException {
		
		System.out.println("f="+f);
		if(!f.isEmpty()) {//파일이 있을 경우에 대한 조건
		System.out.println("name = " + f.getName());
		System.out.println("originalFilename = " + f.getOriginalFilename());
		System.out.println("size = " + f.getSize());
		System.out.println("contentType = " + f.getContentType());
		
		File dir = new File("/Users/silverz/git/upload");
		File target = new File(dir, f.getOriginalFilename());
		f.transferTo(target);//저장
		}
		return "redirect:upload";
	}
	
	/**
	 *	여러 개의 파일이 같은 이름으로 업로드 되는 상황 
	 *	= 배열 또는 List로 처리
	 */
	@PostMapping("/upload2")
	//public String upload2(@RequestParam MultipartFile[] f) {
	public String upload2(@RequestParam List<MultipartFile> f) {
		System.out.println("f = " + f);
		
		if(!f.get(0).isEmpty()) {//없어도 1개는 비어있는 상태로 들어온다
		for(MultipartFile mf : f) {
			System.out.println("파일 발견!");
			System.out.println("name = " + mf.getName());
			System.out.println("originalFilename = " + mf.getOriginalFilename());
			System.out.println("size = " + mf.getSize());
			System.out.println("contentType = " + mf.getContentType());
		}
		}
		return "redirect:upload";
	}

	@PostMapping("/upload3")
	public String upload3(
				@RequestParam String studentName,
				@RequestParam int studentScore,
				@RequestParam MultipartFile studentProfile
			) {
		System.out.println("studentName = " + studentName);
		System.out.println("studentScore = " + studentScore);
		System.out.println("originalFilename = " + studentProfile.getOriginalFilename());
		System.out.println("size = " + studentProfile.getSize());
		System.out.println("contentType = " + studentProfile.getContentType());
		return "redirect:upload";
	}
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/upload4")
	public String upload3(@ModelAttribute StudentVO studentVO) throws IllegalStateException, IOException {
		studentService.studentRegistration(studentVO);		
		return "redirect:upload";
	}
	
}
















