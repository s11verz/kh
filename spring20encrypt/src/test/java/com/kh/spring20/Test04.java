package com.kh.spring20;

import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {

	//단방향 암호화의 대표 알고리즘인 SHA 알고리즘을 적용
	//= 원하는 PasswordEncoder를 선택
	//= encode라는 명령으로 암호화 구현
	//= matches라는 명령으로 확인
	
	@Test
	public void test() {
		String origin = "hello";
		log.debug("origin = {}", origin);
		
		PasswordEncoder encoder = new StandardPasswordEncoder();
		String encrypt = encoder.encode(origin);
		log.debug("encrypt = {}", encrypt);
		
		//boolean match = encoder.matches(비교할문자열, 암호화된문자열)
		boolean match = encoder.matches("hello", encrypt);
		log.debug("match = {}", match);
	}
	
}

