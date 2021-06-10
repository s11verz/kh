  
package home.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ItemDao;
import home.beans.ItemDto;

@WebServlet(urlPatterns = "/item/itemInsert.kh")
public class ItemInsertServlet extends HttpServlet{
	//doPost는 오로지 post방식의 요청만 처리한다.
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				//준비 : 아이템명, 아이템 ---> 아이템정보(ItemDto)
				req.setCharacterEncoding("UTF-8");
				ItemDto itemDto = new ItemDto();
				itemDto.setItemName(req.getParameter("itemName"));
				itemDto.setItemPrice(Integer.parseInt(req.getParameter("itemPrice")));
				
				//처리
				ItemDao itemDao = new ItemDao();
				itemDao.insert(itemDto);
				
				//출력 : 목록 페이지
				resp.sendRedirect("itemList.jsp");
			}
			catch(Exception e) {
				e.printStackTrace();
				resp.sendError(500);
			}
		}
}


