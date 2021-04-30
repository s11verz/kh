package study.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/product/total.kh")
public class ProductTotalListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			통합 검색 서블릿(분배기)
//			= 사용자는 전체목록 or 구간검색 or 항목검색을 하게 되어 있다
//			= 각각의 상황에 따라 파라미터가 다르게 주어진다
//			= 파라미터의 상태에 따라 미리 만들어둔 다른 서블릿으로 "재접속 하도록" 지시하면 어떨까?
//			= 이것을 리다이렉트(Redirect)라고 부른다
			
//			if(type과 keyword라는 파라미터가 있으면) {
//				/product/search.kh로 다시 접속하세요!
//			}
//			else if(begin과 end라는 파라미터가 있으면) {
//				/product/rank.kh로 다시 접속하세요!
//			}
//			else {
//				/product/list.kh로 다시 접속하세요!
//			}
			
			if(req.getParameter("type") != null && req.getParameter("keyword") != null) {
				String type = req.getParameter("type");
				String keyword = req.getParameter("keyword");
//				resp.sendRedirect("사용자 브라우저 주소창에 작성해야할 주소(풀주소)");
				resp.sendRedirect("http://localhost:8080/study/product/search.kh?type="+type+"&keyword="+keyword);
			}
			else if(req.getParameter("begin") != null && req.getParameter("end") != null) {
				int begin = Integer.parseInt(req.getParameter("begin"));
				int end = Integer.parseInt(req.getParameter("end"));
				
				resp.sendRedirect("http://localhost:8080/study/product/rank.kh?begin="+begin+"&end="+end);
			}
			else {
				resp.sendRedirect("http://localhost:8080/study/product/list.kh");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}