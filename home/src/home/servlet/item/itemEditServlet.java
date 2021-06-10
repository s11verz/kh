package home.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ItemDao;
import home.beans.ItemDto;

@WebServlet(urlPatterns="/item/itemEdit.kh")
public class itemEditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		req.setCharacterEncoding("UTF-8");
		ItemDto itemDto=new ItemDto();
		itemDto.setItemNo(Integer.parseInt(req.getParameter("itemNo")));
		itemDto.setItemName(req.getParameter("itemName"));
		itemDto.setItemPrice(Integer.parseInt(req.getParameter("itemPrice")));
		
		ItemDao itemDao=new ItemDao();
		itemDao.edit(itemDto);
		
		resp.sendRedirect("itemDetail.jsp?itemNo="+itemDto.getItemNo());
		
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
