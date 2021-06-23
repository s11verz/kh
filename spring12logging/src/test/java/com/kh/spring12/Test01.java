package com.kh.spring12;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {
	
	private Logger log=LoggerFactory.getLogger(Test01.class);
	
	@Test
	public void test() {
		
//		System.out.println("Debug Message");
//		System.out.println("Info Message");
//		System.out.println("Warn Message");
//		System.out.println("Error Message");
		
		log.debug("Debug Message");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
	}
	

}
