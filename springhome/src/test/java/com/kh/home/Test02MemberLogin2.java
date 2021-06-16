package com.kh.home;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.home.entity.MemberDto;

//import junit.framework.Assert;



//아이디와 비밀번호를 이용한 로그인 판정 코드를 작성 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test02MemberLogin2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		String sql="select * from member where member_id=? and member_pw=?";
		Object[] param= {"testuser1201","testuser1201"};
		
		//RowMapper 대신 사용할 수 있는 '단일조회'용 변환 도구 
		ResultSetExtractor<MemberDto> extractor=(rs)->{
			
				if(rs.next()) {
					MemberDto memberDto=new MemberDto();
					memberDto.setMemberNo(rs.getInt("member_no"));
					memberDto.setMemberId(rs.getString("member_id"));
					memberDto.setMemberPw(rs.getString("member_pw"));
					memberDto.setMemberNick(rs.getString("member_nick"));
					memberDto.setMemberBirth(rs.getString("member_birth"));
					memberDto.setMemberEmail(rs.getString("member_email"));
					memberDto.setMemberPhone(rs.getString("member_phone"));
					memberDto.setMemberPoint(rs.getInt("member_point"));
					memberDto.setMemberJoin(rs.getDate("member_join"));
					memberDto.setMemberGrade(rs.getString("member_grade"));
					
					return memberDto;
				}else {
					return null;
				}
		};
		
		
			
	
		MemberDto memberDto=jdbcTemplate.query(sql,extractor,param);
		System.out.println(memberDto);
	}

}






















