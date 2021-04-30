package study.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ItemDao;
import study.beans.ItemDto;

@WebServlet(urlPatterns="/item/edit.kh")
public class ItemEditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ItemDto itemDto=new ItemDto();
			itemDto.setItemNo(Integer.parseInt(req.getParameter("itemNo")));
			itemDto.setItemName(req.getParameter("itemName"));
			itemDto.setItemPrice(Integer.parseInt(req.getParameter("itemName")));
			
			ItemDao itemDao=new ItemDao();
			boolean result=itemDao.edit(itemDto);
			
			resp.setCharacterEncoding("MS949");
		
			if(result) {
				resp.getWriter().println("가격 수정 완료");
			}else {
				resp.getWriter().println("존재하지 않는 번호");
			}
					
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		
	}}
