package com.kh.spring21.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring21.entity.PaymentDto;
import com.kh.spring21.entity.ProductDto;
import com.kh.spring21.repository.PaymentDao;
import com.kh.spring21.repository.ProductDao;
import com.kh.spring21.service.PayService;
import com.kh.spring21.vo.KakaoPayApprovePrepareVO;
import com.kh.spring21.vo.KakaoPayApproveVO;
import com.kh.spring21.vo.KakaoPayCancelPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;
import com.kh.spring21.vo.KakaoPaySearchVO;

@Controller
@RequestMapping("/shop")
public class ShoppingController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", productDao.list());
		return "shop/home";
	}
	
	@GetMapping("/detail/{no}")
	public String detail(@PathVariable int no, Model model) {
		model.addAttribute("productDto", productDao.get(no));
		return "shop/detail";
	}
	
	@PostMapping("/buy")
	public String buy(
			@RequestParam int no, @RequestParam int quantity,
			Model model) {
		ProductDto productDto = productDao.get(no);
		model.addAttribute("productDto", productDto);
		model.addAttribute("quantity", quantity);		
		int total_amount = productDto.getPrice() * quantity;
		model.addAttribute("total_amount", total_amount);
		return "shop/buy";
	}
	
	@Autowired
	@Qualifier("kakaoPayService2")
	private PayService payService;
	
	@PostMapping("/confirm")
	public String confirm(
			HttpSession session, 
			@ModelAttribute KakaoPayReadyPrepareVO prepareVO
			) throws URISyntaxException {
		int memberNo = (int)session.getAttribute("memberNo");//회원번호 추출
		prepareVO.setPartner_user_id(String.valueOf(memberNo));
		
		KakaoPayReadyVO readyVO = payService.ready(prepareVO);
		
		session.setAttribute("partner_order_id", readyVO.getPartner_order_id());
		session.setAttribute("partner_user_id", readyVO.getPartner_user_id());
		session.setAttribute("tid", readyVO.getTid());
		
		return "redirect:"+readyVO.getNext_redirect_pc_url();
	}
	@GetMapping("/success")
	public String success(
			HttpSession session,
			@ModelAttribute KakaoPayApprovePrepareVO prepareVO) throws URISyntaxException {
		//세션에서 데이터를 추출 후 삭제
		prepareVO.setPartner_order_id((String)session.getAttribute("partner_order_id"));
		prepareVO.setPartner_user_id((String)session.getAttribute("partner_user_id"));
		prepareVO.setTid((String)session.getAttribute("tid"));
		
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		KakaoPayApproveVO approveVO = payService.approve(prepareVO);
		
		//결제 정보 조회 페이지 또는 결제 성공 알림페이지로 리다이렉트 한다
		return "redirect:historyDetail?paymentNo="+prepareVO.getPartner_order_id();
	}

	@Autowired
	private PaymentDao paymentDao;
	
	@GetMapping("/history")
	public String history(HttpSession session, Model model) {
		int memberNo = (int)session.getAttribute("memberNo");
		model.addAttribute("list", paymentDao.list(memberNo));
		return "shop/history";
	}
	
	@GetMapping("/historyDetail")
	public String historyDetail(@RequestParam int paymentNo, Model model) throws URISyntaxException {
		//결제 정보 조회
		PaymentDto paymentDto = paymentDao.get(paymentNo);
		model.addAttribute("paymentDto", paymentDto);
		
		//카카오 서버 조회
		KakaoPaySearchVO searchVO = payService.search(paymentDto.getPaymentTid());
		model.addAttribute("searchVO", searchVO);
		
		return "shop/historyDetail";
	}
	
	@GetMapping("/refund")
	public String refund(
			//paymentNo, cancel_amount를 수신한다
			@ModelAttribute KakaoPayCancelPrepareVO prepareVO
			) throws URISyntaxException {
		payService.cancel(prepareVO);
		return "redirect:historyDetail?paymentNo="+prepareVO.getPaymentNo();
	}

}

