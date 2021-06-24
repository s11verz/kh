package com.kh.spring14.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	@RequestMapping("/")
	public String home(@CookieValue (required=false)String visit, Model model) { //해당하는 이름의 쿠키 값을 읽어오는 어노테이션 - spring에서는 어노테이션을 이용하여 특정 쿠키만 가져올 수 있음 
//		System.out.println("visit="+visit);
		model.addAttribute("visit", visit);
		return "home";
	}
	
	//쿠키 생성 - 쿠키 객체를 만들어 사용자에게 보냄 
	@RequestMapping("/create")
	public String create(HttpServletResponse response) throws UnsupportedEncodingException {
		String time="한글입니다!";
		String encode=URLEncoder.encode(time,"UTF-8");//불편한 값들에 대한 변환 
		Cookie cookie=new Cookie("visit",encode); //쿠키 객체 생성 
		cookie.setMaxAge(1*24*60*60); //쿠키의 유효시간을 초단위로 설정 
		response.addCookie(cookie); //쿠키를 사용자에게 보냄 
		return "redirect:/";
	}
	
	//쿠키 삭제 - 기존의 쿠키와 동일한 이름 객체를 만들어 0초 뒤에 소멸되도록 설정 
	@RequestMapping("/delete")
	public String delete(HttpServletResponse response) {
		Cookie cookie=new Cookie("visit","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);		
		return "redirect:/";
	}
	
	@RequestMapping("/show")
	public String show(HttpServletResponse response) {
		Cookie cookie = new Cookie("show", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/";
	}
	
	@RequestMapping("/hide")
	public String hide(HttpServletResponse response) {
		//시간 계산
		Calendar c = Calendar.getInstance();//익일 0시 0분 0초
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		Date d = new Date();//현재시간
		
		long gap = c.getTimeInMillis() - d.getTime();
		int gapSecond = (int)(gap / 1000);
		
		Cookie cookie = new Cookie("show", "");
		cookie.setMaxAge(gapSecond);
		response.addCookie(cookie);
		return "redirect:/";
	}
	
}








