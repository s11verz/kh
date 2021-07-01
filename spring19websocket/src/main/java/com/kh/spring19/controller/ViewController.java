package com.kh.spring19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

	
	
	@GetMapping("/basic")
	public String basic() {
		return "ws/basic";
	}
	
	@GetMapping("/member")
	public String member() {
		return "ws/member";
	}
	
	//hello 채널 : http://localhost:8080/spring19/view/channel/hello
		//hi 채널 : http://localhost:8080/spring19/view/channel/hi
		@GetMapping("/channel/{channel}")
		public String channel(@PathVariable String channel, Model model) {
			
			return "ws/channel";
		}
}
