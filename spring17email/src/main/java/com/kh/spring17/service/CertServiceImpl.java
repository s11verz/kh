package com.kh.spring17.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring17.entity.CertDto;
import com.kh.spring17.repository.CertDao;

import lombok.extern.slf4j.Slf4j;

@Service @Slf4j
public class CertServiceImpl implements CertService{

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private RandomService randomService;

	@Override
	public void sendCertification(String email) throws MessagingException {
		String no=randomService.generateCertification(6);//번호 생성 
		
		//이메일 발송 
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo(email);
		helper.setSubject("[kh정보교육원] 인증번호 발송메일");
		helper.setText("인증번호 : "+no);
		
		//데이터베이스 등록 
		certDao.insert(CertDto.builder()
						.email(email)
						.no(no)
						.build());
		
		sender.send(message);
		
		
		
	}
	
	@Override
	@Transactional
	public boolean checkCertification(CertDto certDto) {
		boolean result = certDao.check(certDto);
		if(result) {
			certDao.deleteByEmail(certDto.getEmail());
		}
		return result;
	}
	
	//스케줄러를 이용한 지속적인 삭제 구현(매 정각마다 삭제. 텀이 길수록 성능이 향상됨)
		@Scheduled(cron = "0 0 * * * *")
		@Override
		public void clearCertification() {
			certDao.clear();
			log.debug("인증정보 테이블 청소가 완료되었습니다");
		}
	
	
}
