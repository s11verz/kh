package com.kh.spring17;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test03 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		MimeMessage message=sender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(message, false, "UTF-8");
		
		String[] to= {"liisa9601@naver.com"};
		helper.setTo(to);
		
		helper.setSubject("마임메세지 테스트");
		helper.setText("테스트 성공!");
	
	}

}
