package com.kh.spring06;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


public class Test03 {
	
	@Test
	public void test() {
		BasicDataSource dbcpSource=new BasicDataSource();
		dbcpSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dbcpSource.setUrl("jdbc:oracle:thin:@10.211.55.3");
		dbcpSource.setUsername("study");
		dbcpSource.setPassword("study");
		dbcpSource.setMaxTotal(20);
		dbcpSource.setMaxIdle(10);
		dbcpSource.setMaxWaitMillis(3000L);
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dbcpSource);
		
		String sql="insert into item values(item_seq.nextval,?,?)";
		Object[] param= {"아디다스신발",30000};
		jdbcTemplate.update(sql, param);
		
	}

}
