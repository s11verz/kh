package com.kh.spring12;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

//롬복에서 지원하는 자동 로깅 도구 생성 기능 
@Slf4j
public class Test02 {
	
	@Test
	public void test() {
		log.debug("Debug Message");
	}

}
