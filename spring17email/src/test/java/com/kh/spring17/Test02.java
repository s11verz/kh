package com.kh.spring17;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test02 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(
				"liisa9601@gmail.com", 
				"dhgkdud4002@naver.com"
		);
		
		message.setCc("liisa9601@naver.com");//참조(Carbon Copy)
		message.setBcc("hiphop5782@naver.com");//숨은 참조(Blind Carbon Copy)
		
		message.setSubject("ohio :) ");
		
		message.setText("오해영~");
		
//		메세지 전송
		sender.send(message);
	}

}
