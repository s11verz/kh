package com.kh.spring19.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageVO {
	private int memberNo;
	private String memberId;
	private String memberNick;
	private long sendTime;
	private String message;
}
