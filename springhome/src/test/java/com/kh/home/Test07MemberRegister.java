package com.kh.home;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kh.home.entity.MemberDto;



public class Test07MemberRegister {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		sqlSession=factory.openSession(false);
	}
	
	
	@Test
	public void test() {
		MemberDto memberDto=MemberDto.builder()
										.memberId("adminuser")
										.memberPw("adminuser")
										.memberNick("애드민")
										.memberBirth("2020-02-02")
										.memberPhone("010-1234-7452")			
										.memberEmail("bb@gmail.com")
										.build();
		
		sqlSession.insert("member.regist",memberDto);
	}
	
	@After
	public void after() {
		sqlSession.commit();
		//sqlSession.rollback();
		
	}

}
