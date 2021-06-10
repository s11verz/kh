package study.servlet.jdbc;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ItemDao;
import study.beans.ItemDto;

@WebServlet(urlPatterns="/multiple.kh")
public class MultipleParameterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//제일 처음 데이터만 읽을 수 있음
			String a=req.getParameter("a");
			resp.getWriter().println("a="+a);
			
			//중복 파라미터 수신 명령 사용
			String[] data=req.getParameterValues("a");
			resp.getWriter().println("data="+Arrays.toString(data));
			
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		
}

}
