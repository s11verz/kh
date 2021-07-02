package com.kh.spring19.vo;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder 
@JsonIgnoreProperties//없을수도 있음 
public class ReceiveVO {

	private int type;
	private String content;
	private String channel;
}
