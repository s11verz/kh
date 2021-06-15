package mvc.servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.ProductDao;
import mvc.beans.ProductDto;

@WebServlet(urlPatterns="/product/productList.kh")
public class ProductListServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		ProductDao productDao=new ProductDao();
		List<ProductDto> list=productDao.list();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/product/productList.jsp");
		dispatcher.forward(req, resp);
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
