package mvc.servlet.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.MemberDao;
import mvc.beans.MemberDto;
@WebServlet(urlPatterns="/member/memberList.kh")
public class MemberListServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		MemberDao memberDao=new MemberDao();
		List<MemberDto> list=memberDao.selectList();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/member/memberList.jsp");
		dispatcher.forward(req, resp);
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
