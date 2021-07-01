package com.kh.spring19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/basic")
	public String basic() {
		return "ws/basic";
	}
}
