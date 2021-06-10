package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns="/member/login.kh")
public class MemberLoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("UTF-8");
		MemberDto memberDto=new MemberDto();
		memberDto.setMemberId(req.getParameter("memberId"));
		memberDto.setMemberPw(req.getParameter("memberPw"));
		
		MemberDao memberDao=new MemberDao();
		MemberDto find=memberDao.login(memberDto);
		
		
		if(find!=null) {
			req.getSession().setAttribute("memberNo",find.getMemberNo());
			resp.sendRedirect(req.getContextPath());
		}else {
			resp.sendRedirect("login.jsp?error");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
