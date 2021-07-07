package com.kh.spring22;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//이 annotation 만으로 스프링 환경 연동이 끝난다
class Spring22bootApplicationTests {

	private Logger log = LoggerFactory.getLogger(Spring22bootApplicationTests.class);
	
	@Test
	void contextLoads() {
		log.info("Hello!");
	}
}
