package com.kh.spring14.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/create")
	public String create(HttpServletResponse response) {
		String time="2021-06-23";
		Cookie cookie=new Cookie("visit",time);
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		return "redirect:/";
	}
}
