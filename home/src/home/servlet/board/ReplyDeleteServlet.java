package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns = "/board/replyDelete.kh")
public class ReplyDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 파라미터(댓글번호, 원본글번호), 세션(회원번호)
			req.setCharacterEncoding("UTF-8");
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReplyNo(Integer.parseInt(req.getParameter("replyNo")));
			replyDto.setReplyOrigin(Integer.parseInt(req.getParameter("replyOrigin")));
			
			int memberNo = (int)req.getSession().getAttribute("memberNo");
			replyDto.setReplyWriter(memberNo);
			
			//댓글 삭제
			ReplyDao replyDao = new ReplyDao();
			replyDao.delete(replyDto);
			//댓글 개수 갱신
			BoardDao boardDao = new BoardDao();
			boardDao.refreshBoardReply(replyDto.getReplyOrigin());
			
			//출력
			resp.sendRedirect("boardDetail.jsp?boardNo="+replyDto.getReplyOrigin());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}