package com.kh.spring17;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring17.entity.CertDto;
import com.kh.spring17.repository.CertDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test07 {
	
	@Autowired
	private CertDao certDao;
	
	@Test
	public void test() {
		certDao.insert(CertDto.builder()
											.email("liisa9601@naver.com")
											.no("123456")
										.build());
	}
	
}

