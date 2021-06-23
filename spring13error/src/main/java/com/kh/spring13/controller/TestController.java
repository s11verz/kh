package com.kh.spring13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller @Slf4j
public class TestController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/error1")
	public String error1() {
		int a=10/0;
		log.debug("a={}",a);
		return "redirect:/";
	}
	
	@ExceptionHandler(ArithmeticException.class) //예외를 처리할 수 있는 메소드를 지정할 때 사용 
	public String handler1() {
		return "error/handler1";
	}

}
