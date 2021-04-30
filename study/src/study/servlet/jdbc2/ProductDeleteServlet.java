package study.servlet.jdbc2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.beans.ProductDao;

@WebServlet(urlPatterns="/jsp/productDelete.kh")
public class ProductDeleteServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int no=Integer.parseInt(req.getParameter("no"));
			
			ProductDao productDao=new ProductDao();
			boolean result=productDao.delete(no);
			
			if(result) {
				resp.sendRedirect("/study/jsp/productDeleteSuccess.jsp");
			}else {
				resp.sendRedirect("/study/jsp/productDeleteFail.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
}
