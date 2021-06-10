package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

@WebServlet(urlPatterns="/board/boardEdit.kh")
public class BoardEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));
			boardDto.setBoardHeader(req.getParameter("boardHeader"));//말머리(파라미터)
			boardDto.setBoardTitle(req.getParameter("boardTitle"));//글제목(파라미터)
			boardDto.setBoardContent(req.getParameter("boardContent"));//글내용(파라미터)
			
			BoardDao boardDao=new BoardDao();
			boardDao.edit(boardDto);
			
			
			resp.sendRedirect("boardDetail.jsp?boardNo="+boardDto.getBoardNo());
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
