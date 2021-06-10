package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardLikeDao;
import home.beans.BoardLikeDto;

@WebServlet(urlPatterns = "/board/boardLikeDelete.kh")
public class BoardLikeDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : memberNo, boardNo
			req.setCharacterEncoding("UTF-8");
			BoardLikeDto boardLikeDto = new BoardLikeDto();
			boardLikeDto.setMemberNo(Integer.parseInt(req.getParameter("memberNo")));
			boardLikeDto.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));
			
			//처리
			BoardLikeDao boardLikeDao = new BoardLikeDao();
			boardLikeDao.delete(boardLikeDto);
			
			BoardDao boardDao = new BoardDao();
			boardDao.refreshBoardLike(boardLikeDto.getBoardNo());
			
			//출력 : 상세보기 페이지 복귀
			resp.sendRedirect("boardDetail.jsp?boardNo="+boardLikeDto.getBoardNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}