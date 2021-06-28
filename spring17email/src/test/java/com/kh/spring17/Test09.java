package com.kh.spring17;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring17.entity.CertDto;
import com.kh.spring17.repository.CertDao;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test09 {
	
	@Autowired
	private CertDao certDao;
	
	@Test
	public void test() {
		CertDto certDto = CertDto.builder()
								.email("liisa9601@naver.com")
								.no("166792")
								.build();
		boolean result = certDao.check(certDto);
		if(result) {
			certDao.deleteByEmail(certDto.getEmail());
		}
		assertTrue(result);
	}
	
}

