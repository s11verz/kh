package com.kh.spring18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//기존의 처리를 수행하는 컨트롤러 - ViewResolver 적용 받음 
@Controller
@RequestMapping("/view")
public class ViewController {

	@GetMapping("/test1")
	public String test1() {
		return "test1"; //jsp
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
}
