package com.kh.spring19.ws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring19.entity.MemberDto;
import com.kh.spring19.repository.MemberDao;
import com.kh.spring19.vo.MessageVO;
import com.kh.spring19.vo.VisitorVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketMemberServer extends TextWebSocketHandler{

	private Set<VisitorVO> visitor = new HashSet<>();
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("session = {}", session);
		log.debug("attributes = {}", session.getAttributes());
		log.debug("memberNo = {}", session.getAttributes().get("memberNo"));
		
		Integer memberNo = (Integer) session.getAttributes().get("memberNo");
		
		//회원일 경우에만 정보를 불러와서 VisitorVO 형태로 저장소에 추가
		if(memberNo != null) {
			MemberDto memberDto = memberDao.get(memberNo);
			VisitorVO visitorVO = VisitorVO.builder()
					.memberNo(memberDto.getMemberNo())
					.memberId(memberDto.getMemberId())
					.memberNick(memberDto.getMemberNick())
					.session(session)
					.build();
			visitor.add(visitorVO);
			log.debug("사용자 접속 (현재 {} 명)", visitor.size());
		}
		else {
			log.debug("비회원 접속(고려하지않음)");
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//회원번호로 삭제 - 번호가 있다면 반복문으로 저장소를 탐색하여 삭제 처리
		VisitorVO user = find(session);
		if(user != null) {
			visitor.remove(user);
			log.debug("접속 종료 (현재 {} 명)", visitor.size());
		}
		else {
			log.debug("비회원 접속 종료(고려하지 않음)");
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//user에 있는 session을 이용하여 메세지를 전송
		//= message에 추가로 회원정보를 보내야 함
		//= JSON 형태
		//= RestController가 아니면 JSON은 자동 변환되지 않음
		//= 수동 변환(ObjectMapper 클래스 사용)
		
		VisitorVO user = find(session);
		
		if(user != null) {
			//메세지에 포함되어야 할 정보
			//= memberNo, memberId, memberNick, sendTime, message
			
			//[1] Map을 이용하여 데이터를 생성
			//Map<String, Object> data = new HashMap<>();
			//data.put("memberNo", user.getMemberNo());
			//data.put("memberId", user.getMemberId());
			//data.put("memberNick", user.getMemberNick());
			//data.put("sendTime", System.currentTimeMillis());
			//data.put("message", message.getPayload());
			
			//[2] 클래스를 이용하여 데이터를 생성
			MessageVO data = MessageVO.builder()
												.memberNo(user.getMemberNo())
												.memberId(user.getMemberId())
												.memberNick(user.getMemberNick())
												.sendTime(System.currentTimeMillis())
												.message(message.getPayload())
											.build();
			
			//객체 --> JSON 변환 코드
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(data);
			
			//TextMessage 생성
			TextMessage tm = new TextMessage(json);
			
			for(VisitorVO vo : visitor) {
				vo.getSession().sendMessage(tm);
			}
			
			//데이터베이스 저장 코드 작성 시점
			
		}
	}
	
	//번외 : WebSocketSession의 memberNo를 이용해서 VisitorVO를 반환하는 기능
	private VisitorVO find(WebSocketSession session) {
		Integer memberNo = (Integer) session.getAttributes().get("memberNo");

		if(memberNo != null) {
			for(VisitorVO user : visitor) {
				if(memberNo == user.getMemberNo()) {
					return user;
				}
			}
		}
		
		return null;
	}
	
}



