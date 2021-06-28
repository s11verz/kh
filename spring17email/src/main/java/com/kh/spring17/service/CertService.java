package com.kh.spring17.service;

import javax.mail.MessagingException;

import com.kh.spring17.entity.CertDto;

public interface CertService {
	//인증번호 발송 기능 
	//-준비물: 수신자 이메일 
	//-결과물: 없음 
	void sendCertification(String email) throws MessagingException;
	
	//인증번호 검사 기능
	//-준비물: CertDto 
	//-결과물: boolean
	boolean checkCertification(CertDto certCto);
	
	//인증시간이 지난 인증데이터 삭제 기능(스케줄러)
		void clearCertification();
}
