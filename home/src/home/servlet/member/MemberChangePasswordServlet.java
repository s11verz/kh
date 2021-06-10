package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/member/mypw.kh")
public class MemberChangePasswordServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 3개(회원번호, 기존비밀번호, 신규비밀번호) ---> DTO라고 볼 수 없다
			int memberNo = (int)req.getSession().getAttribute("memberNo");
			
			req.setCharacterEncoding("UTF-8");
			String curPw = req.getParameter("curPw");
			String newPw = req.getParameter("newPw");
			
			//처리
			MemberDao memberDao = new MemberDao();
			
			//1번 : 기존 방법을 사용
			//MemberDto memberDto = memberDao.find(memberNo);
			//boolean result = memberDao.changePassword(memberDto.getMemberId(), curPw, newPw);
			
			//2번 : 신규 방법을 사용
			boolean result = memberDao.changePassword(memberNo, curPw, newPw);
			
			//출력 : 완료페이지 또는 입력페이지
			if(result) {//성공 시
				resp.sendRedirect("mypwSuccess.jsp");
			}
			else {//실패 시
				resp.sendRedirect("mypw.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}