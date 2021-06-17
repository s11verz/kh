package com.kh.spring07;

import org.junit.Test;

public class Test02 {

	@Test
	public void test() {
		Member member= new Member("testuser","test1234");
		
		Member member2=Member.builder().id("testuser").password("test1234").build();
		
		System.out.println(member);
		System.out.println(member2);
	}
}
