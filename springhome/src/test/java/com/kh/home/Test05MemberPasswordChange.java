package com.kh.home;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//비밀번호 변경이 정상적으로 이루어지는지 확인 
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
public class Test05MemberPasswordChange {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private int memberNo;
	private String currentPassword;
	private String newPassword;
	
	@Before
	public void before() {
		memberNo=15;
		currentPassword="admin1234";
		newPassword="adminadmin1";
	}
	
	@Test
	public void test() {
		String sql="update member set member_pw=? where member_no=? and member_pw=?";
		Object[] param= {newPassword,memberNo,currentPassword};
		int count=jdbcTemplate.update(sql,param);
		
		assertEquals(1,count);
	}
	
	@After
	public void after() {
		//롤백 등의 작업
	}

}
