package com.kh.spring20;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test05 {

	@Test
	public void test() {
		String origin = "hello";
		log.debug("origin = {}", origin);
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encrypt = encoder.encode(origin);
		log.debug("encrypt = {}", encrypt);
		
		boolean match = encoder.matches("hello", encrypt);
		log.debug("match = {}", match);
	}
	
}