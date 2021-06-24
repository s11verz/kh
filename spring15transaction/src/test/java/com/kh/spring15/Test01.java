package com.kh.spring15;
//수동으로 트랜잭션 관리를 구현 

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration @Slf4j
public class Test01 {
	
	@Autowired
	private SqlSessionFactory factory;
	
	@Test
	public void test() {
		SqlSession sqlSession=factory.openSession(false);
		
		try {
			sqlSession.insert("student.insert1");
			sqlSession.insert("student.insert2");
			
			sqlSession.commit();
			log.debug("commit");
				
		}catch(Exception e) {
			sqlSession.rollback();
			
		}
		
	}

}
