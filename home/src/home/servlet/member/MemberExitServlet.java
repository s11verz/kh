package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;
@WebServlet(urlPatterns="/member/exit.kh")
public class MemberExitServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int memberNo=(int)req.getSession().getAttribute("memberNo");
			
			MemberDao memberDao=new MemberDao();
			
			memberDao.exit(memberNo);
			
			req.getSession().removeAttribute("memberNo");
			resp.sendRedirect("goodbye.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	}
