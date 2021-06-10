package study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/*사용자의 요청을 접수하기 전에 검사할 수 있는 도구*/
@WebFilter(urlPatterns="/member/myinfo.jsp")
public class TestFilter implements Filter{
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	
	HttpServletRequest req=(HttpServletRequest)request;
	HttpServletRequest resp=(HttpServletRequest)response;
	
	System.out.println("필터가 실행되었습니다");
	chain.doFilter(request, response);
}
}
