package com.kh.spring18.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring18.entity.MemberDto;
import com.kh.spring18.repository.MemberDao;

//비동기 통신에 대응하는 컨트롤러 - ViewResolver 적용 받지 않음 
@RestController //@Controller+@ResponseBody 
@RequestMapping("/data")
public class DataController {

	@GetMapping("/test1")
	public String test1() {
		return "test1"; //문자열 
	}
	
	@GetMapping("/test2")
	public String test2(@RequestParam int a, @RequestParam int b) {
		return String.valueOf(a+b);
	}
	
	@Autowired
	private MemberDao memberDao;
	
	@PostMapping("/test3")
	public String test3(
			@RequestParam String memberId
		) {
//	테스트1 : admin이면 사용중, 아니면 가능
//	if(memberId.equals("admin")) return "N";
//	else return "Y";
		
		//테스트2 : 데이터베이스에 존재하면 사용중, 아니면 가능 
		if(memberDao.exist(memberId)) return "N";
		else return "Y";
	
}
//	Member 목록을 반환
//	= 기본 Spring RestController에서는 String만 반환 가능
//	= 그외 자료형들을 반환하고 싶으면 "변환" 작업이 필요하며 이를 수행하는 라이브러리 필요
//	= Gson, Jackson 등의 라이브러리들이 유명
//	= Jackson-databind 의존성을 추가하기만 하면 모든 형태 데이터가 변환된다
	@GetMapping("/test4")
	public List<MemberDto> test4(){
		return memberDao.list();
	}
}
