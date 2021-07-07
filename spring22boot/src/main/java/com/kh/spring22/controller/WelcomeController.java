package com.kh.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	@ResponseBody//view resolver 미적용
	public String home() {
		return "Hello Spring Boot!";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";//view resolver 적용
	}
	
}