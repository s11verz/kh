package com.kh.spring08.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component//도구
//@Service//기능묶음(서비스)
public class SpringFilter implements Filter{

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SpringFilter 실행");
		chain.doFilter(request, response);
	}

}