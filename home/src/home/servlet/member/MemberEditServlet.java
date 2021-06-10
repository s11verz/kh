package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/member/myedit.kh")
public class MemberEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 세션(회원번호) , 파라미터(나머지5개 정보) --> 회원정보(DTO)
			req.setCharacterEncoding("UTF-8");
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberNo((int)req.getSession().getAttribute("memberNo"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			
			//처리
			MemberDao memberDao = new MemberDao();
			boolean result = memberDao.changeInformation(memberDto);
			
			//출력
			if(result) {
				resp.sendRedirect("myeditSuccess.jsp");
			}
			else {
				resp.sendRedirect("myedit.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
