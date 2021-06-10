package study.servlet.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.ProductDao;
import study.beans.ProductDto;

@WebServlet(urlPatterns = "/product/search.kh")
public class ProductSearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : type(검색분류) , keyword(검색어)q
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
//			계산
			ProductDao productDao = new ProductDao();
			List<ProductDto> productList = productDao.search(type, keyword);
			
//			출력
			resp.setCharacterEncoding("MS949");
			for(ProductDto productDto : productList) {
				resp.getWriter().println(productDto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}