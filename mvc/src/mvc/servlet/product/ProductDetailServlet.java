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

@WebServlet(urlPatterns="/product/productDetail.kh")
public class ProductDetailServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int no=Integer.parseInt(req.getParameter("no"));
		ProductDao productDao=new ProductDao();
		ProductDto productDto=productDao.get(no);
		req.setAttribute("productDto", productDto);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/product/productDetail.jsp");
		dispatcher.forward(req, resp);
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
