package com.kh.spring21.vo;
//카카오 페이의 결제 요청에 따른 응답정보를 저장하기 위한 vo

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class KakaoPayReadyVO {

	private String tid;
	private String next_redirect_pc_url;
	private String created_at;
}
