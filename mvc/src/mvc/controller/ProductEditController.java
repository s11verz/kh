package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductEditController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "/WEB-INF/jsp/product/productEdit.jsp";
	}

	
}
