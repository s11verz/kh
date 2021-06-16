package com.kh.home;
//테스트 목적
//= Spring-JDBC를 이용하여 회원가입을 구현
//= Spring 환경을 연동하여 테스트 진행

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test01MemberRegist {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		String sql = "insert into member values("
				+ "member_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?, 0, '일반')";
		Object[] param = {
				/* 아이디 */		"testuser1201",
				/* 비밀번호 */	"testuser1201",
				/* 닉네임 */		"테스트계정",
				/* 생년월일 */	"1999-01-02" ,
				/* 전화번호 */	"010-5060-7080",
				/* 이메일 */		"khacademy@kh.com"
		};
		jdbcTemplate.update(sql, param);
	}
	
}






