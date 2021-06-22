package com.kh.spring11.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentVO {
	private String studentName;
	private String studentEmail;
	private MultipartFile studentProfile;
}