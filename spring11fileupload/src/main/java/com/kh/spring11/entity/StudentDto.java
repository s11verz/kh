package com.kh.spring11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentDto {
	private int studentNo;
	private String studentName;
	private String studentEmail;
}