package com.kh.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.home.entity.MemberDto;
import com.kh.home.repository.MemberDao;

@Controller
//공용주소 설치
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	//회원가입 관련 요청 처리
	@GetMapping("/regist")
	public String regist() {
		//return "/WEB-INF/views/member/regist.jsp";
		return "member/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		
		return "redirect:regist_success";
	}
	
	@GetMapping("/regist_success")
	public String registSuccess() {
		return "member/registSuccess";
	}
	
	//로그인 요청 처리
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		MemberDto find=memberDao.login(memberDto);
		if(find!=null) {//성공
			session.setAttribute("memberNo", find.getMemberNo());
			return "redirect:/";
		}else {//실패
			return "redirect:login?error";
		}
	}
	
	//로그아웃 구현
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("memberNo");
		return "redirect:/";
	}
	
	//내정보 보기
	@GetMapping("/myinfo")
	public String myinfo(@ModelAttribute MemberDto memberDto, HttpSession session) {
		MemberDto find=memberDao.myinfo(memberDto);
		session.setAttribute("memberNo", find.getMemberNo());
		return null;
	}
	
}



















