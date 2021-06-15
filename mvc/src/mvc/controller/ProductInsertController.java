package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.ProductDao;
import mvc.beans.ProductDto;

public class ProductInsertController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return "/WEB-INF/jsp/product/productInsertInput.jsp";
		}
		else if(req.getMethod().equals("POST")) {
			//데이터 수신 및 데이터베이스 등록
			ProductDto productDto = new ProductDto();
			productDto.setName(req.getParameter("name"));
			productDto.setType(req.getParameter("type"));
			productDto.setPrice(Integer.parseInt(req.getParameter("price")));
			productDto.setMade(req.getParameter("made"));
			productDto.setExpire(req.getParameter("expire"));
			
			ProductDao productDao = new ProductDao();
			productDao.registItem(productDto);
			
			//forward가 아니라 작업이 끝났으므로 다른 기능으로 redirect
			return "redirect:productList.it";
		}
		return null;//throw new Exception();
	}

}