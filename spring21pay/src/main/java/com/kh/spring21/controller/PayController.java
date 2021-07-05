package com.kh.spring21.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring21.service.PayService;
import com.kh.spring21.vo.KakaoPayApprovePrepareVO;
import com.kh.spring21.vo.KakaoPayApproveVO;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;

@Controller @RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayService payService;
	
//	@GetMapping("/cancel")
//	@GetMapping("/fail")
	
	@GetMapping("/confirm")
	public String confirm() {
		return "pay/confirm";
	}
	
	@PostMapping("/confirm")
	public String confirm(HttpSession session, @ModelAttribute KakaoPayReadyPrepareVO prepareVO) throws URISyntaxException {
		//결제 준비 요청 
		KakaoPayReadyVO readyVO=payService.ready(prepareVO);
		
		//승인 요청을 위해 정보를 DB/세션 등에 저장해야 함 =partner_order_id, partner_user_id, tid
		session.setAttribute("partner_order_id", prepareVO.getPartner_order_id());
		session.setAttribute("partner_user_id", prepareVO.getPartner_user_id());
		session.setAttribute("tid", readyVO.getTid());
		
		//사용자에게 결제 페이지 주소로 재접속 지시를 내림 
		return "redirect:"+readyVO.getNext_redirect_pc_url();
	}
	
	@GetMapping("/success")
	public String success(HttpSession session, @ModelAttribute KakaoPayApprovePrepareVO prepareVO) throws URISyntaxException {
		//세션에서 데이터 추출 
		prepareVO.setPartner_order_id((String)session.getAttribute("partner_order_id"));
		prepareVO.setPartner_user_id((String)session.getAttribute("partner_user_id"));
		prepareVO.setTid((String)session.getAttribute("tid"));
		
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		KakaoPayApproveVO approveVO=payService.approve(prepareVO);
		
		//결제 승인 완료 : 승인 정보를 DB에 저장하는 등의 작업 수행 
		
		//결제 정보 조회 페이지 또는 결제 성공 알림페이지로 리다이렉트 
		return "redirect:result_success";
		
	}
	
	@GetMapping("/result_success")
	public String resultSuccess() {
		return "pay/resultSuccess";
	}

}
