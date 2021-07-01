package com.kh.spring19.ws;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//public class WebSocketBasicServer implements WebSocketHandler{
public class WebSocketBasicServer extends TextWebSocketHandler{
	
	//사용자를 관리할 저장소 구현
	private Set<WebSocketSession> visitor = new HashSet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		visitor.add(session);
		log.debug("사용자 접속! {}", session);
		log.debug("현재 사용자 : {} 명", visitor.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		visitor.remove(session);
		log.debug("사용자 접속 종료! {}, {}", session, status);
		log.debug("현재 사용자 : {} 명", visitor.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("사용자 메세지 수신!");
		log.debug("session = {}, message = {}", session, message);
		
		//에코(echo) 메세지 : 전송자에게 메세지를 반송
		//session.sendMessage(message);
		
		//전체(broadcast) 메세지 : 접속한 모든 사용자에게 메세지를 전달
		for(WebSocketSession user : visitor) {
			user.sendMessage(message);
		}
	}
	
}