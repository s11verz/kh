package study.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ProductDao;
import study.beans.ProductDto;

@WebServlet(urlPatterns = "/product/detail.kh")
public class ProductDetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
//			준비
			int no = Integer.parseInt(req.getParameter("no"));
			
//			계산
			ProductDao productDao = new ProductDao();
			ProductDto productDto = productDao.get(no);
			
//			출력
			resp.setCharacterEncoding("MS949");
			if(productDto == null) {
				resp.getWriter().println("존재하지 않는 상품입니다");
			}
			else {
				resp.getWriter().println(productDto);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
