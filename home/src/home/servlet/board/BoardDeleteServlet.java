package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;

@WebServlet(urlPatterns="/board/boardDelete.kh")
public class BoardDeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int boardNo=Integer.parseInt(req.getParameter("boardNo"));
		
		BoardDao boardDao=new BoardDao();
		boardDao.delete(boardNo);
		
		resp.sendRedirect("boardList.jsp");
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
