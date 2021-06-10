package home.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ItemDao;

@WebServlet(urlPatterns = "/item/itemDelete.kh")
public class ItemDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비
			int itemNo = Integer.parseInt(req.getParameter("itemNo"));
			
			//처리
			ItemDao itemDao = new ItemDao();
			itemDao.delete(itemNo);
			
			//출력
			resp.sendRedirect("itemList.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}