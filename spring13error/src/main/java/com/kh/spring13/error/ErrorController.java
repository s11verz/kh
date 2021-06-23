package com.kh.spring13.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

//컨트롤러를 간섭하기 위한 클래스 
//@ControllerAdvice(basePackages="com.kh.spring13.controller")
@Slf4j
@ControllerAdvice(annotations= {Controller.class})
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public String handler(HttpServletRequest request, Exception e) {
		log.error("IP:{}",request.getRemoteAddr());
		log.error("오류발생",e);
		return "error/handler1";
	}
}
