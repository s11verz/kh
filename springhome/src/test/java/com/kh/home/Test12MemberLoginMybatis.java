package com.kh.home;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.home.entity.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test12MemberLoginMybatis {
	
	private Logger log = LoggerFactory.getLogger(Test12MemberLoginMybatis.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	@Before
	public void before() {
		sqlSession = sqlSessionFactory.openSession(false);
	}
	
	@Test
	public void test() {
		MemberDto memberDto = MemberDto.builder()
										.memberId("testuser1202")
										.memberPw("testuser1202")
										.build();
		MemberDto findDto = sqlSession.selectOne("member.login", memberDto);
//		System.out.println(findDto);
		log.debug("{}", findDto);
	}
	
	@After
	public void after() {
		sqlSession.rollback();
	}
	
	
}