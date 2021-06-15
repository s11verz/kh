package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.ProductDao;
import mvc.beans.ProductDto;

public class ProductDetailController implements Controller{
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//계산 및 첨부 코드(DB)
		int no = Integer.parseInt(req.getParameter("no"));
		ProductDao productDao = new ProductDao();
		ProductDto productDto = productDao.get(no);
		
		req.setAttribute("productDto", productDto);
		
		//포워드 코드
		return "/WEB-INF/jsp/product/productDetail.jsp";
	}
}
