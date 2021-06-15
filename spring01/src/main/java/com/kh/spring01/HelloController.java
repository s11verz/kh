package com.kh.spring01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("Message","스프링에 오신 걸 환영합니다!");
		mv.setViewName("/WEB-INF/views/hello.jsp");
		
		
		return mv;
	} 
	
	

}
