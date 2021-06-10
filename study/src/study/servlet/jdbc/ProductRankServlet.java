
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

@WebServlet(urlPatterns = "/product/rank.kh")
public class ProductRankServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 시작번호(begin) , 종료번호(end)
			int begin = Integer.parseInt(req.getParameter("begin"));
			int end = Integer.parseInt(req.getParameter("end"));			
			
//			계산
			ProductDao productDao = new ProductDao();
			List<ProductDto> productList = productDao.rank(begin, end);
			
//			출력 : 검색 결과
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