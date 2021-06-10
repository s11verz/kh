package study.servlet.jdbc2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.beans.ItemDao;
import study.beans.ItemDto;

@WebServlet(urlPatterns="/jsp/ItemInsert2.kh")
public class ItemInsertServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("EUC-KR");
			ItemDto itemDto=new ItemDto();
			itemDto.setItemName(req.getParameter("itemName"));
			itemDto.setItemPrice(Integer.parseInt(req.getParameter("itemPrice")));
			
			ItemDao itemDao =new ItemDao();
			int itemNo=itemDao.sequence();
			itemDto.setItemNo(itemNo);
			itemDao.insert2(itemDto);
			
			resp.sendRedirect("itemDetail.jsp?itemNo="+itemNo);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
