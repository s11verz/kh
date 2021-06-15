package com.kh.spring03;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/dice")
	public String dice(Model model) {
		Random r=new Random();
		int dice=r.nextInt(6)+1;
		
		model.addAttribute("dice",dice);
		
		return "dice";
	}
	
	@RequestMapping("/plus")
	public String plus(HttpServletRequest request,Model model) {
		
		int a=Integer.parseInt(request.getParameter("a"));
		int b=Integer.parseInt(request.getParameter("b"));
		int total=a+b;
		
		model.addAttribute("total",total);
		
		return "test/plus";
	}
	
	@RequestMapping("/plus2")
	public String plus2(@RequestParam int a,@RequestParam int b, Model model) {
		model.addAttribute("total",a+b);
		return "test/plus";
	}
	
	@RequestMapping("/plus3")
	public String plus3(@ModelAttribute TestDto testDto, Model model) {
		model.addAttribute("total",testDto.getA()+testDto.getB());
		return "test/plus";
	}
}































