package com.kh.spring11.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentProfileDto {

	private int profileNo;
	private String profileUploadName;
	private String profileSaveName;
	private String profileContentType;
	private long profileSize;
	private int profileOrigin;
}
