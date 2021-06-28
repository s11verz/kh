package com.kh.spring17.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CertServiceImpl implements CertService{

	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendCertification(String email) throws MessagingException {
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(email);
		helper.setSubject("[kh정보교육원] 인증번호 발송메일");
		helper.setText("인증번호 : 123456");
		
		sender.send(message);
		
		
		
	}
	
	
}
