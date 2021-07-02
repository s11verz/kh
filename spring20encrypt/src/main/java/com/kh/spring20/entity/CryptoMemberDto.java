package com.kh.spring20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CryptoMemberDto {

	private String memberId, memberPw, memberNick;
}
