package mvc.servlet.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.ProductDao;
import mvc.beans.ProductDto;

@WebServlet(urlPatterns="/product/productInsertProc.kh")
public class ProductInsertProcServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			ProductDto productDto=new ProductDto();
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));
			
			ProductDao productDao=new ProductDao();
			productDao.registItem(productDto);
				
			RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/product/productInsertProc.jsp");
			dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
