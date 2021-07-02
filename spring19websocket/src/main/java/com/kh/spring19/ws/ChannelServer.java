package com.kh.spring19.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kh.spring19.vo.VisitorVO;

import lombok.extern.slf4j.Slf4j;

/**
 *	채널을 관리할 수 있는 서버
 *	= 필드 : 대기실 , 채널저장소
 *	= 메소드 : 채널생성(사용자입장), 채널삭제(사용자퇴장), 채널퇴장, 대기실입장, 대기실퇴장  
 */
@Slf4j
public class ChannelServer {
	
	private List<VisitorVO> waiting = new ArrayList<>();//대기실
	private List<Channel> channels = new ArrayList<>();//채널저장소
	
	//채널 탐색
	public boolean exist(String name) {
		return find(name) != null;
	}
	public Channel find(String name) {
		for(Channel channel : channels) {
			if(channel.getName().equals(name)) {
				return channel;
			}
		}
		return null;
	}
	
	//대기실 입장
	public void start(VisitorVO visitorVO) {
		waiting.add(visitorVO);
		log.debug("대기실 입장 - 현재 대기자 {} 명", waiting.size());
	}
	
	//사용자 입장(+ 채널 생성) = 대기실 퇴장 + (채널 생성) + 채널 추가
	public void enter(int memberNo, String name) {
		VisitorVO user = findWaiting(memberNo);
		waiting.remove(user);
		
		Channel channel = find(name);
		if(channel == null) {//채널이 없는 경우에는 채널을 추가한다
			channel = new Channel(name);
			channels.add(channel);
			log.debug("신규 채널 생성 : {}", name);
		}
		
		channel.enter(user);
	}
	
	//사용자 퇴장(+ 채널 삭제)
	//= 채널 탐색 + 사용자 제거 + (채널 삭제)
	public void leave(int memberNo, String name) {
		Channel channel = find(name);
		channel.leave(memberNo);
		
//		if(channel.getUsers().size() == 0) {
		if(channel.isEmpty()) {
			channels.remove(channel);
			log.debug("채널 삭제 : {}", name);
		}
	}
	public void leave(int memberNo) {
		for(Channel channel : channels) {
			leave(memberNo, channel.getName());
		}
	}
	
	//대기실 탐색
	public VisitorVO findWaiting(int memberNo) {
		for(VisitorVO user : waiting) {
			if(user.getMemberNo() == memberNo) {
				return user;
			}
		}
		return null;
	}
	
	//채널 메세지 전송
	public void send(int memberNo, String channelName, String message) throws IOException {
		Channel channel = find(channelName);
		if(channel != null) {
			channel.send(memberNo, message);
		}
	}
}






