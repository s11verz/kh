package mvc.servlet.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/product/productInsertInput.kh")
public class ProductInsertInputServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/product/productInsertInput.jsp");
			dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
