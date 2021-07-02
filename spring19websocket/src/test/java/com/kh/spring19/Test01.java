package com.kh.spring19;

import org.junit.Test;

import com.kh.spring19.vo.VisitorVO;
import com.kh.spring19.ws.ChannelServer;

public class Test01 {

	@Test
	public void test() {
		ChannelServer server=new ChannelServer();
		
		for(int i=0;i<=100;i++) {
		server.start(VisitorVO.builder()
				.memberNo(i)
				.memberId("test"+i)
				.memberNick("test"+i)
				.build());
		}
		//50번 회원을 hello 채널에 입장 
		server.enter(50, "hello");
		server.enter(51, "hello");
		server.enter(77, "java");
		server.enter(78, "java");
		server.enter(79, "java");
		
	}
}
