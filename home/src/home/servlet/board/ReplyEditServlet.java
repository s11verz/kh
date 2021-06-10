package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ReplyDao;
import home.beans.ReplyDto;

//댓글 등록 서블릿
@WebServlet(urlPatterns = "/board/replyEdit.kh")
public class ReplyEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			ReplyDto replyDto=new ReplyDto();
			replyDto.setReplyNo(Integer.parseInt(req.getParameter("replyNo")));
			replyDto.setReplyContent(req.getParameter("replyContent"));
			replyDto.setReplyOrigin(Integer.parseInt(req.getParameter("replyOrigin")));
			
			int memberNo=(int)req.getSession().getAttribute("memberNo");
			replyDto.setReplyWriter(memberNo);
			
			ReplyDao replyDao=new ReplyDao();
			replyDao.edit(replyDto);
			resp.sendRedirect("boardDetail.jsp?boardNo="+replyDto.getReplyOrigin());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}