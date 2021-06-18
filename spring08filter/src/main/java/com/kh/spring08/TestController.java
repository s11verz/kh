package com.kh.spring08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	//@ResponseBody : View Resolver를 사용하지 않고 응답 정보를 직접 생성하겠다.

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home";
	}
	
	@RequestMapping("/test1")
	@ResponseBody
	public String test1() {
		return "test1";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public String test2() {
		return "test2";
	}
	
	@RequestMapping("/test1/sub1")
	@ResponseBody
	public String test1sub1() {
		return "test1sub1";
	}
	
	@RequestMapping("/test1/sub2")
	@ResponseBody
	public String test1sub2() {
		return "test1sub2";
	}
	
	@RequestMapping("/test1/sub3")
	@ResponseBody
	public String test1sub3() {
		return "test1sub3";
	}
	
	@RequestMapping("/test2/sub1")
	@ResponseBody
	public String test2sub1() {
		return "test2sub1";
	}
	
	@RequestMapping("/test2/sub2")
	@ResponseBody
	public String test2sub2() {
		return "test2sub2";
	}
	
	@RequestMapping("/test2/sub3")
	@ResponseBody
	public String test2sub3() {
		return "test2sub3";
	}
	
	@RequestMapping("/test1/sub1/child1")
	@ResponseBody
	public String test1sub1child1() {
		return "test1sub1child1";
	}
	
	@RequestMapping("/test1/sub1/child2")
	@ResponseBody
	public String test1sub1child2() {
		return "test1sub1child2";
	}
	
	@RequestMapping("/test3")
	public String test3() {
		return "test3";
	}
}