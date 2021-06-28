package com.kh.spring17.service;

import javax.mail.MessagingException;

public interface CertService {
	//인증번호 발송 기능 
	//-준비물: 수신자 이메일 
	//-결과물: 없음 
	void sendCertification(String email) throws MessagingException;

}
