package com.kh.spring17;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
public class Test05 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
//		1. 마임메세지 객체 생성
		MimeMessage message = sender.createMimeMessage();
		
//		2. 설정도구 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
//		3. 정보 설정
		String[] to = {"liisa9601@naver.com"};
		helper.setTo(to);
		
		helper.setSubject("첨부파일 테스트");
		
//		4. HTML 파일을 불러와서 양식을 첨부하는 테스트 - 첨부위치는 classpath로 잡음 
		ClassPathResource resource=new ClassPathResource("email/template.html");
		File file=resource.getFile();
		
		StringBuffer buffer=new StringBuffer();
		
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine()) {
			String line=sc.nextLine();
			buffer.append(line);
		}
		
//		5. 전송
		sender.send(message);
	}

}

















