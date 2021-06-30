package com.kh.home;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String login(@ModelAttribute MemberDto memberDto, 
						@RequestParam(required=false)String saveId,
						HttpSession session, 
						HttpServletResponse response) {
		MemberDto find=memberDao.login(memberDto);
		if(find!=null) {//성공
			session.setAttribute("memberNo", find.getMemberNo());
			if(saveId!=null) {
				Cookie cookie=new Cookie("saveId",find.getMemberId());
				cookie.setMaxAge(4*7*24*60*60);//4주 
				response.addCookie(cookie);
			}else {
				Cookie cookie=new Cookie("saveId",find.getMemberId());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
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
	@RequestMapping("/myinfo")
	public String myinfo(HttpSession session, Model model) {
		int memberNo=(int)session.getAttribute("memberNo");
		MemberDto memberDto=memberDao.get(memberNo);
		
		model.addAttribute("memberDto",memberDto);
		
		return "member/myinfo";
	}
	
	//회원 탈퇴
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		int memberNo=(int)session.getAttribute("memberNo");
		memberDao.delete(memberNo);
		
		session.removeAttribute("memberNo");
		return "redirect:goodbye";
		
	}
	
	@GetMapping("/goodbye")
	public String goodbye() {
		return "/member/goodbye";
	}
	
	//비밀번호 변경 
	@GetMapping("/change_pw")
	public String changePw() {
		return "member/changePw";
	}
	
	@PostMapping("/change_pw")
	public String changePw(HttpSession session, @RequestParam (value="curPw") String curPassword, @RequestParam(value="newPw") String newPassword) {
		int memberNo=(int)session.getAttribute("memberNo");
		boolean result=memberDao.changePassword(memberNo, curPassword, newPassword);
		if(result) {
			return "redirect:change_pw_success";
		}else {
			return "redirect:change_pw?error";
		}
	}
	
	@GetMapping("/change_pw_success")
	public String changePwSuccess() {
		return "member/changePwSuccess";
	}
	
	//내정보 변경 
	@GetMapping("/change_info")
	public String changeInfo(HttpSession session, Model model) {
		int memberNo=(int)session.getAttribute("memberNo");
		MemberDto memberDto=memberDao.get(memberNo);
		
		model.addAttribute("memberDto",memberDto);
		return "member/changeInfo";
	}
	
	@PostMapping("/change_info")
	public String changeInfo(HttpSession session, @ModelAttribute MemberDto memberDto) {
		int memberNo=(int)session.getAttribute("memberNo");
		memberDto.setMemberNo(memberNo);
		boolean result=memberDao.changeInformation(memberDto);
		if(result) {
			return "redirect:myinfo";
		}else {
			return "redirect:change_info?error";
		}
		
	}
	
	@GetMapping("/change_info_success")
	public String changeInfoSuccess() {
		//return "/WEB-INF/views/member/changeInfoSuccess.jsp";
		return "member/changeInfoSuccess";
	}
}





























































