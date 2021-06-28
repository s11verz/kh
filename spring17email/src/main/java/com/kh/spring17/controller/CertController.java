package com.kh.spring17.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring17.entity.CertDto;
import com.kh.spring17.service.CertService;

@Controller
public class CertController {

	@Autowired
	private CertService certService;
	
	@GetMapping("/cert1")
	public String cert1() {
		return "cert1";
	}
	@PostMapping("/cert1")
	public String cert1(@RequestParam String email, RedirectAttributes attr) throws MessagingException {
		certService.sendCertification(email);
//		return "redirect:cert2?email="+email;//직접 추가 - 권장x
		attr.addAttribute("email",email);
		return "redirect:cert2";
	}
	
	@GetMapping("/cert2")
	public String cert2() {
		return "cert2";
	}
	@PostMapping("/cert2")
	public String cert2(@ModelAttribute CertDto certDto) {
		boolean result=certService.checkCertification(certDto);
		if(result) {
			return "redirect:cert3";
		}
		else {
			return "redirect:cert2?error";
		}
	}
	
	@GetMapping("/cert3")
	public String cert3() {
		return "cert3";
	}
	
}
