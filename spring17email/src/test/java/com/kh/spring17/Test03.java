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
//		1. 마임메세지 객체 생성
		MimeMessage message = sender.createMimeMessage();
		
//		2. 설정도구 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
//		3. 정보 설정
		String[] to = {"liisa9601@naver.com"};
		helper.setTo(to);
		
//		String[] cc = {};
//		helper.setCc(cc);
		
//		String[] bcc = {};
//		helper.setBcc(bcc);
		
		helper.setSubject("마임메세지 테스트");
		helper.setText("테스트 성공 히히!");
		
//		4. 전송
		sender.send(message);
	}

}
