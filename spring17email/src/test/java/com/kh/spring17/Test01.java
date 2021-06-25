package com.kh.spring17;

import java.util.Properties;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//목표 : 독립테스트로 이메일 발송
//1. 전송도구 : JavaMailSender(JavaMailSenderImpl)
//2. 메세지객체 : SimpleMailMessage
public class Test01 {
	
	@Test
	public void test() {
//		메세지 전송 도구 생성
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");//이용할 Vender IP 정보
		sender.setPort(587);//이용할 Vender port 정보
		sender.setUsername("silverzz0124");//이용할 계정명
		sender.setPassword("dmswldmswl!");//이용할 계정 비밀번호
		
		Properties props = new Properties();//문자열만 저장하는 Map
		props.setProperty("mail.smtp.auth", "true");//인증 설정
		props.setProperty("mail.smtp.starttls.enable", "true");//TLS 사용설정
		props.setProperty("mail.smtp.debug", "true");//디버깅 설정(옵션)
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		sender.setJavaMailProperties(props);
		
//		메세지 생성
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

