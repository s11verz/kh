package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {
		"/member/myinfo.jsp",
		"/member/myedit.jsp", "/member/myedit.kh", "/member/myeditSuccess.jsp",
		"/member/mypw.jsp", "/member/mypw.kh", "/member/mypwSuccess.jsp",
		"/member/exit.kh",
		"/member/logout.kh",
		"/product/*",
		"/board/*"
})
public class MemberFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//통과 = 로그인 상태 = HttpSession에 memberNo가 존재하는 상황
		//차단 = 로그아웃 상태 = HttpSession에 memberNo가 존재하지 않는 상황
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		boolean isLogin = req.getSession().getAttribute("memberNo") != null;
		
		if(isLogin) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
		}
	}
}
