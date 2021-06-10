package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.MemberDao;
import home.beans.MemberDto;

/**
 *	이 필터는 "작성자 본인" 또는 "관리자"만 게시글 삭제, 수정에 접근할 수 있도록 하기 위한 필터이다. 
 */
@WebFilter(urlPatterns = {
		"/board/boardEdit.jsp", "/board/boardEdit.kh", "/board/boardDelete.kh"
})
public class BoardCheckFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//통과명령 : chain.doFilter(request, response);
		
		//필터에서는 request와 response를 쓰려면 다음과 같이 다운캐스팅해야 한다.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		try {
			//알아내야 할 정보 : 세션에 있는 회원번호 , 파라미터에 있는 게시글번호
			int memberNo = (int)req.getSession().getAttribute("memberNo");
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.find(memberNo);
			
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.get(boardNo);
			if(memberNo == boardDto.getBoardWriter()) {//본인이라면
				chain.doFilter(request, response);
			}
			else if(memberDto.getMemberGrade().equals("관리자")) {//관리자라면
				chain.doFilter(request, response);
			}
			else {//본인이 아니라면
				resp.sendError(403);//Forbidden, 권한없음
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}




