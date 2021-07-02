package com.kh.spring19.ws;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring19.vo.MessageVO;
import com.kh.spring19.vo.VisitorVO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//1개의 채널 
//필드 : 채널명, 저장소 
//메소드 : 채널입장, 채널퇴장, 사용자 찾기, 메세지 전송 

@Slf4j
public class Channel {
	@Setter @Getter
	private String name;
	@Getter
	private Set<VisitorVO> users;
	
	@Builder
	public Channel(String name) {
		this.name=name;
		this.users=new HashSet<>();
	}

	//입장 
	public void enter(VisitorVO visitorVO) {
		users.add(visitorVO);
		log.debug("{} 채널 사용자 입장 : 이용자 {}명", name, users.size());
	}
	
	//퇴장 
	public void leave (int memberNo) {
		for(VisitorVO user:users) {
			if(user.getMemberNo()==memberNo) {
				leave(user);
				break;
			}
		}
	}
	public void leave(VisitorVO visitorVO) {
		users.remove(visitorVO);
		log.debug("{} 채널 사용자 퇴장 : 이용자 {}명", name, users.size());
	}
	
	//메세지 전송 
	public void send(int memberNo, String message) throws IOException {
		//발신인 정보 탐색 
		VisitorVO user=find(memberNo);
		
		//메세지 생성 
		MessageVO messageVO=MessageVO.builder()
								.memberNo(user.getMemberNo())
								.memberId(user.getMemberId())
								.memberNick(user.getMemberNick())
								.sendTime(System.currentTimeMillis())
								.message(message)
								.build();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(messageVO);
		
		TextMessage tm=new TextMessage(json);
		for(VisitorVO visitorVO:users) {
			visitorVO.getSession().sendMessage(tm);
		}
	}
	//유저 탐색 
	public VisitorVO find(int memberNo) {
		for(VisitorVO user:users) {
			if(user.getMemberNo()==memberNo) {
				return user;
			}
		}return null;
	}
	
	public boolean isEmpty() {
		return users.size()==0;
	}
}



















