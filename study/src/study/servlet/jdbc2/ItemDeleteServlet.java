package study.servlet.jdbc2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.beans.ItemDao;

@WebServlet(urlPatterns="/jsp/itemDelete.kh")
public class ItemDeleteServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int itemNo=Integer.parseInt(req.getParameter("itemNo"));
			
			ItemDao itemDao=new ItemDao();
			boolean result=itemDao.delete(itemNo);
			
			resp.sendRedirect("/study/jsp/itemList.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	
}
