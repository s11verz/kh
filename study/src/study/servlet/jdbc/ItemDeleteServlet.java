package study.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ItemDao;
import study.beans.MemberDao;
import study.beans.MemberDto;

@WebServlet(urlPatterns="/item/delete.kh")
public class ItemDeleteServlet extends HttpServlet{
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			int itemNo=Integer.parseInt(req.getParameter("itemNo"));
			
			ItemDao itemDao=new ItemDao();
			boolean result=itemDao.delete(itemNo);
			
			if(result) {
				resp.getWriter().println("삭제 완료");
			}else {
				resp.getWriter().println("존재하지 않는 번호");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		
}

}