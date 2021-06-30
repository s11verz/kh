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

public class Test11updatePw {

	
private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		sqlSession=factory.openSession(false);
		//System.out.println(factory);
	}
	
	@Test
	public void test() {
		MemberDto memberDto=MemberDto.builder()
										.memberPw("changepw")
										.memberNo(20)
										.memberPw("adminuser")
										.build();
		
		sqlSession.update("member.changePw",memberDto);
	}
	
	
	@After
	public void after() {
		sqlSession.commit();
		//sqlSession.rollback();
		
	}

}
