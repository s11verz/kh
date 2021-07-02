package com.kh.spring20;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {

	//시저 암호화 
	//모든 글자에 + 혹은 -를 수행하여 암호화 수행 
	@Test
	public void test() {
		int number=100;
		log.debug("number={}", number);
		
		int encrypt=number-5;
		log.debug("encrypt={}",encrypt);
		
		int decrypt=encrypt+5;
		log.debug("decrypt={}",decrypt);
	}
	
	@Test
	public void test2() {
		String text="hello";
		
		StringBuffer encrypt=new StringBuffer();
		
		for(int i=0;i<text.length();i++) {
			char c=text.charAt(i);
			c-=5;
			encrypt.append(c);
		}
		log.debug("encrypt={}",encrypt.toString());
		
		StringBuffer decrypt=new StringBuffer();
		for(int i=0;i<encrypt.length();i++) {
			char c=encrypt.charAt(i);
			c+=5;
			decrypt.append(c);
		}
		log.debug("decrypt={}",decrypt.toString());
	}
}
