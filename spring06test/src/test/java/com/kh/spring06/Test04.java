package com.kh.spring06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith: 추가적으로 적용시킬 환경 정보 설정 
//@ContextConfiguration: 설정파일 정보 설정 
//@WebAppConfiguration: 가상의 web.xml을 사용하겠다는 설정 

//경로설정방법 2가지 
//1. file: 프로젝트 폴더로부터 시작하는 경로 
//2. classpath: wepabb을 제외한 src 내부의 경로 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class Test04 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		//System.out.println(jdbcTemplate);
				String sql = "insert into item values(item_seq.nextval, ?, ?)";
				Object[] param = {"실내화", 3000};
				jdbcTemplate.update(sql, param);
		
	}
	
}
