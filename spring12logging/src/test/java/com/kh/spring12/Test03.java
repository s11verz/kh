package com.kh.spring12;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {
	
	@Test
	public void test() {
		log.debug("Logger에는 한 개의 문자열을 출력할 수 있습니다");
		log.debug("값을 출력할 경우 특수문자를 지원합니다. a={}",10);
		
		int a=10;
		int b=20;
		log.debug("a={}, b={}",a,b);
		
		//객체는 직접 출력이 x 
		Object c=new Object();
		System.out.println(c);
//		log.debug(c);//에러 
		log.debug(c.toString());
		log.debug("{}",c);
		
	}

}
