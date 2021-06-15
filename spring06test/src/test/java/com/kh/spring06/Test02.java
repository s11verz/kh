package com.kh.spring06;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02 {
	
	@Test
	public void test() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.211.55.3");
		dataSource.setUsername("study");
		dataSource.setPassword("study");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql="insert into item values(item_seq.nextval,?,?)";
		Object[] param= {"나이키신발",30000};
		jdbcTemplate.update(sql, param);
	}

}
