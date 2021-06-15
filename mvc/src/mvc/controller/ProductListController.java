package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.ProductDao;
import mvc.beans.ProductDto;

public class ProductListController implements Controller{
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//준비, 계산, 첨부
		ProductDao productDao = new ProductDao();
		List<ProductDto> list = productDao.list();
		
		req.setAttribute("list", list);
		
		return "/WEB-INF/jsp/product/productList.jsp";
	}
}