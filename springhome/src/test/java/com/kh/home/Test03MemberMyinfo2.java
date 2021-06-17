package com.kh.home;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.home.entity.MemberDto;
import com.kh.home.repository.MemberDao;

//테스트 목적 : 회원번호를 이용한 단일조회 테스트
//입력 : 17
//출력 : 회원 정보(MemberDto)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test03MemberMyinfo2 {

	@Autowired
	private MemberDao memberDao;

	@Test
	public void test() {
		int memberNo = 17;
		
		MemberDto memberDto = memberDao.get(memberNo);
		
		assertNotNull(memberDto);
	}
	
}





