package study.servlet.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ItemDao;
import study.beans.ItemDto;

@WebServlet(urlPatterns = "/item/list.kh")
public class ItemListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//준비 : X
			
			//데이터베이스 처리
			ItemDao itemDao = new ItemDao();
			List<ItemDto> itemList = itemDao.list();
			
			//출력
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("데이터 개수 : "+itemList.size());
			for(ItemDto itemDto : itemList) {
				resp.getWriter().println(itemDto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
