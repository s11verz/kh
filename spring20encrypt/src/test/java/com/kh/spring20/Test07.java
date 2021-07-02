package com.kh.spring20;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring20.entity.CryptoMemberDto;
import com.kh.spring20.repository.CryptoMemberDao;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration @Slf4j
public class Test07 {

	@Autowired
	private CryptoMemberDao cryptoMemberDao;
	
	@Test
	public void login() {
		CryptoMemberDto result=cryptoMemberDao.login(CryptoMemberDto.builder()
													.memberId("testuser1234")
													.memberPw("testuser1234")
													.build());
		log.debug("result : {}", result);
		assertNotNull(result);
	}
}
