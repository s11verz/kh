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
import com.kh.spring19.vo.ReceiveVO;
import com.kh.spring19.vo.VisitorVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketChannelServer extends TextWebSocketHandler{
	
	private ChannelServer server = new ChannelServer();
	
	@Autowired
	private MemberDao memberDao;
	
	//상수
	public static final int JOIN = 1;
	public static final int MESSAGE = 2;
	public static final int LEAVE = 3;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//접속 시에 채널을 알 수 있는 방법이 없으므로 우선 대기실로 입장시킨다.
		// = 사용자가 접속 후에 본인이 몇채널인지 서버로 메세지를 전송해야 한다.
		// = 채널은 사용자가 메세지를 접속하자마자 첫 메세지를 전송하는 순간 알 수 있다.
		Integer memberNo = (Integer) session.getAttributes().get("memberNo");
		
		if(memberNo == null) return; //비회원 고려하지 않음
		
		MemberDto memberDto = memberDao.get(memberNo);
		server.start(VisitorVO.builder()
												.memberNo(memberDto.getMemberNo())
												.memberId(memberDto.getMemberId())
												.memberNick(memberDto.getMemberNick())
												.session(session)
											.build());
	}
	
	//사용자가 보낼 수 있는 메세지의 형태는 크게 2가지로 볼 수 있다.
	//1. 채널 입장 메세지
	//2. 일반 채팅 메세지
	//3. 채널 퇴장 메세지
	//따라서 그냥 text만으로는 구분이 어려우므로 JSON 형태로 수신해야 한다.
	//= 형태는 정하기 나름이며, 다음과 같이 약속한다.
	//= {"type" : 작업유형 , "content" : "메세지" , "channel" : "채널명" }
	//ex : hello라는 채널에 입장하겠다는 메세지 형태
	//= {"type":1 , "channel": "hello"}
	//ex : hello라는 채널에 "안녕하세요" 라고 보낼 경우의 메세지 형태
	//= {"type":2 , "channel": "hello" , "content" : "안녕하세요" }
	//ex : hello라는 채널에서 퇴장하겠다는 메세지 형태
	//= {"type":3 , "channel": "hello"}
	//위의 메세지를 담을 수 있는 객체를 ReceiveVO 라는 형태로 구현
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//메세지의 payload를 가져온다(JSON String)
		String payload = message.getPayload();
		
		//payload를 ReceiveVO 객체로 변환한다(Jackson , ObjectMapper)
		ObjectMapper mapper = new ObjectMapper();
		ReceiveVO receiveVO = mapper.readValue(payload, ReceiveVO.class);
		
		Integer memberNo = (Integer) session.getAttributes().get("memberNo");
		if(memberNo == null) return;
		
		//JOIN(1) 이면 대기실에 있는 사용자를 채널로 이동
		//MESSAGE(2) 이면 해당 채널에 메세지를 전송
		if(receiveVO.getType() == JOIN) {
			server.enter(memberNo, receiveVO.getChannel());
		}
		else if(receiveVO.getType() == MESSAGE) {
			server.send(memberNo, receiveVO.getChannel(), receiveVO.getContent());
		}
		else if(receiveVO.getType() == LEAVE) {
			server.leave(memberNo, receiveVO.getChannel());
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//여기서는 회원번호만 알 수 있다.
		Integer memberNo = (Integer) session.getAttributes().get("memberNo");
		if(memberNo == null) return;
		
		server.leave(memberNo);
	}
	
}





