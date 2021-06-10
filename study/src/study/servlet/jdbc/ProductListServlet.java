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

@WebServlet(urlPatterns = "/product/list.kh")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 없음
			
//			계산 : Product 테이블의 모든 데이터를 List형태로 수집
			ProductDao productDao = new ProductDao();
			List<ProductDto> productList = productDao.list();
			
//			출력 : 모든 데이터를 화면에 출력
			resp.setCharacterEncoding("MS949");
			for(ProductDto productDto : productList) {
//				resp.getWriter().println(productDto.getNo());
//				resp.getWriter().println(productDto.getName());
				resp.getWriter().println(productDto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}