package com.kh.home;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kh.home.entity.MemberDto;

public class Test09select {
	
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
		
		Map<String,Object> map=new HashMap<>();
		map.put("type", "member_no");
		map.put("keyword", 15);
		
		List<MemberDto> list=sqlSession.selectList("member.select",map);
		for(MemberDto memberDto:list) {
			System.out.println(memberDto);
		}
		
	}
	
	
	@After
	public void after() {
		//sqlSession.commit();
		sqlSession.rollback();
		
	}

}
