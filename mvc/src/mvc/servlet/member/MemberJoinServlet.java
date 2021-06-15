package mvc.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.MemberDao;
import mvc.beans.MemberDto;

@WebServlet(urlPatterns="/member/memberJoin.kh")
public class MemberJoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/member/memberJoin.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			MemberDto memberDto=new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			
			MemberDao memberDao=new MemberDao();
			memberDao.regist(memberDto);
		
			resp.sendRedirect("https://naver.com");
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
