package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

@WebServlet(urlPatterns="/board/boardWrite.kh")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 파라미터 3개(제목, 내용, 말머리) + 세션 1개(회원번호) + DB조회 1개(시퀀스번호) = BoardDto
			// = 계층형 게시판에서 답글일 경우 상위글번호(superNo)가 추가적으로 파라미터에 전송된다.
			req.setCharacterEncoding("UTF-8");
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardHeader(req.getParameter("boardHeader"));//말머리(파라미터)
			boardDto.setBoardTitle(req.getParameter("boardTitle"));//글제목(파라미터)
			boardDto.setBoardContent(req.getParameter("boardContent"));//글내용(파라미터)
			
			int memberNo = (int)req.getSession().getAttribute("memberNo");//회원번호(세션)
			boardDto.setBoardWriter(memberNo);
			
			BoardDao boardDao = new BoardDao();
			int boardNo = boardDao.getSequence();//게시글번호(DB시퀀스)
			boardDto.setBoardNo(boardNo);
			
			//superNo라는 파라미터가 있을 경우 답글로 간주한다
			if(req.getParameter("superNo") != null) {//답글일 경우 : 상위글 정보를 불러와서 계산
				boardDto.setSuperNo(Integer.parseInt(req.getParameter("superNo")));
				
				BoardDto superDto = boardDao.get(boardDto.getSuperNo());
				boardDto.setGroupNo(superDto.getGroupNo());//상위글 그룹번호와 동일하게 설정
				boardDto.setDepth(superDto.getDepth() + 1);//상위글 차수 + 1
			}
			else {//새글일 경우 : 그룹번호를 글번호로 설정하고 나머지는 0
				boardDto.setGroupNo(boardNo);
				//boardDto.setSuperNo(0);
				//boardDto.setDepth(0);
			}
			
			//처리
			boardDao.write(boardDto);
			
			//출력 : 상세페이지로 이동
			resp.sendRedirect("boardDetail.jsp?boardNo="+boardNo);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}