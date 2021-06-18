package com.kh.spring08.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//과거에 Dynamic Web Project에서 사용하던 필터
//[1] Filter를 상속받는다
//[2] 메소드를 재정의한다
//[3] web.xml 또는 annotation으로 등록한다
public class LegacyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LegacyFilter 실행");
		chain.doFilter(request, response);
	}

}
