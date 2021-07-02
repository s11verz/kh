package com.kh.spring20;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {

	//단방향 암호화 : 데이터를 의도적으로 절삭하여 원본이 추리 불가능하도록 구현 - 의도적으로 결과물의 크기를 키워서 충돌이 발생하지 않도록 구현 
	@Test
	public void test() {
		int number=3;
		log.debug("number : {}",number);
		
		int encrypt=number*123456789%10;
		log.debug("encrypt : {}",encrypt);
	}
}
