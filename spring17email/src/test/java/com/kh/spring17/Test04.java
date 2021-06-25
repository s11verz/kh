package com.kh.spring17;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
public class Test04 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, UnsupportedEncodingException {
//		1. 마임메세지 객체 생성
		MimeMessage message = sender.createMimeMessage();
		
//		2. 설정도구 생성 - 파일을 보내려면 multipart=true 설정 
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
//		3. 정보 설정
		String[] to = {"liisa9601@naver.com"};
		helper.setTo(to);
		
//		String[] cc = {};
//		helper.setCc(cc);
		
//		String[] bcc = {};
//		helper.setBcc(bcc);
		
		helper.setSubject("첨부파일 테스트");
		helper.setText("테스트 성공 히히!");
//		helper.setText("<h1>안녕<h1>",true);
		
		
//		4. 첨부파일 추가 - javax.activation.DataSource를 사용 
		DataSource dataSource=new FileDataSource("/Users/silverz/Downloads/welcome.jpeg");
		String originName="어서와";
		String attachementName=new String(originName.getBytes("UTF-8"),"8859_1");
		helper.addAttachment(attachementName, dataSource);
		
//		5. 전송
		sender.send(message);
	}

}
