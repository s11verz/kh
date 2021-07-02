package com.kh.spring20;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {

	@Test
	public void test() {
		int number=12345678;
		log.debug("number={}",number);
		
		int encrypt=number^5;
		log.debug("encrypt={}",encrypt);
		
		int decrypt=encrypt^5;
		log.debug("decrypt={}",decrypt);
		
	}
}
