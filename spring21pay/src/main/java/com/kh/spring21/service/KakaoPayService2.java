package com.kh.spring21.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.entity.PaymentDto;
import com.kh.spring21.repository.PaymentDao;
import com.kh.spring21.vo.KakaoPayApprovePrepareVO;
import com.kh.spring21.vo.KakaoPayApproveVO;
import com.kh.spring21.vo.KakaoPayCancelPrepareVO;
import com.kh.spring21.vo.KakaoPayCancelVO;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;
import com.kh.spring21.vo.KakaoPaySearchVO;

import lombok.extern.slf4j.Slf4j;

//PaymentDao까지 이용하여 실제로 DB에도 저장하는 서비스
@Slf4j
@Service
public class KakaoPayService2 implements PayService{

	@Autowired
	private PaymentDao paymentDao;
	
	//사업자 번호, Admin Key는 절대로 변하지 않는다
	public static final String cid = "TC0ONETIME ";
	public static final String adminKey = "f6db56456d7ddef31a08cc2d1735c190";
	public static final String kakaoAk = "KakaoAK " + adminKey;
	public static final String contentType = "application/x-www-form-urlencoded;charset=utf-8";

	@Override
	public KakaoPayReadyVO ready(KakaoPayReadyPrepareVO kakaoPayReadyPrepareVO) throws URISyntaxException {
		//카카오페이에서 요구하는 준비를 위한 요청 주소
		//POST /v1/payment/ready HTTP/1.1
		//Host: kapi.kakao.com
		//Authorization: KakaoAK {APP_ADMIN_KEY}
		//Content-type: application/x-www-form-urlencoded;charset=utf-8
		
		int paymentNo = paymentDao.getSequence();//주문번호 생성
		kakaoPayReadyPrepareVO.setPartner_order_id(String.valueOf(paymentNo));
		
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", kakaoAk);
		headers.add("Content-type", contentType);
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", cid);//가맹점ID(사업자 제휴 시 발급, 테스트용 ID 사용)
		body.add("partner_order_id", kakaoPayReadyPrepareVO.getPartner_order_id());//판매자 구분 ID
		body.add("partner_user_id", kakaoPayReadyPrepareVO.getPartner_user_id());//구매자 구분 ID
		body.add("item_name", kakaoPayReadyPrepareVO.getItem_name());//명세서에 표시될 구매 내역(다건 구매일 경우 ???외 ?건 형식)
		body.add("quantity", String.valueOf(kakaoPayReadyPrepareVO.getQuantity()));//구매수량
		body.add("total_amount", String.valueOf(kakaoPayReadyPrepareVO.getTotal_amount()));//총 구매금액
		body.add("tax_free_amount", String.valueOf(kakaoPayReadyPrepareVO.getTax_free_amount()));//면세금액(없으면 0)
		
		body.add("approval_url", "http://localhost:8080/spring21/shop/success");//사용자 결제 성공시 신호를 받을 주소
		body.add("cancel_url", "http://localhost:8080/spring21/shop/cancel");//사용자 결제 취소시 신호를 받을 주소
		body.add("fail_url", "http://localhost:8080/spring21/shop/fail");//사용자 결제 실패시 신호를 받을 주소
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//[6] 전송
		KakaoPayReadyVO readyVO = template.postForObject(uri, entity, KakaoPayReadyVO.class);
		log.debug("readyVO = {}", readyVO);
		log.debug("url = {}", readyVO.getNext_redirect_pc_url());
		log.debug("tid = {}", readyVO.getTid());
		
		//DB 등록 작업 수행
		PaymentDto paymentDto = PaymentDto.builder()
												.paymentNo(Integer.parseInt(kakaoPayReadyPrepareVO.getPartner_order_id()))
												.paymentTid(readyVO.getTid())
												.paymentBuyer(Integer.parseInt(kakaoPayReadyPrepareVO.getPartner_user_id()))
												.paymentProduct(kakaoPayReadyPrepareVO.getNo())
											.build();
		paymentDao.ready(paymentDto);
		
		//컨트롤러에서 사용할 수 있도록 추가 데이터를 세팅하여 반환
		readyVO.setPartner_order_id(kakaoPayReadyPrepareVO.getPartner_order_id());
		readyVO.setPartner_user_id(kakaoPayReadyPrepareVO.getPartner_user_id());
		
		return readyVO;
	}

	@Override
	public KakaoPayApproveVO approve(KakaoPayApprovePrepareVO kakaoPayApprovePrepareVO) throws URISyntaxException {
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", kakaoAk);
		headers.add("Content-type", contentType);
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", cid);
		body.add("tid", kakaoPayApprovePrepareVO.getTid());//결제준비 응답정보에 포함된 TID 항목 값
		body.add("partner_order_id", kakaoPayApprovePrepareVO.getPartner_order_id());//결제준비 요청정보에 포함된 PARTNER_ORDER_ID 항목 값
		body.add("partner_user_id", kakaoPayApprovePrepareVO.getPartner_user_id());//결제준비 요청정보에 포함된 PARTNER_USER_ID 항목 값
		body.add("pg_token", kakaoPayApprovePrepareVO.getPg_token());//결제 성공 시 파라미터로 전달되는 PG_TOKEN 항목 값
		
		//[4] Http Header / Body 합성	
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//[6] 전송
		KakaoPayApproveVO approveVO = 
				template.postForObject(uri, entity, KakaoPayApproveVO.class);
		log.debug("approveVO = {}", approveVO);
		
		//[7] DB의 결제정보를 승인으로 변경
		paymentDao.approve(Integer.parseInt(kakaoPayApprovePrepareVO.getPartner_order_id()));
		
		return approveVO;
	}

	@Override
	public KakaoPaySearchVO search(String tid) throws URISyntaxException {
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", kakaoAk);
		headers.add("Content-type", contentType);
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", cid);
		body.add("tid", tid);
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//[6] 전송
		KakaoPaySearchVO searchVO = template.postForObject(uri, entity, KakaoPaySearchVO.class);
		log.debug("searchVo = {}", searchVO);
		
		return searchVO;
	}

	@Override
	public KakaoPayCancelVO cancel(KakaoPayCancelPrepareVO prepareVO) throws URISyntaxException {
		
		PaymentDto paymentDto = paymentDao.get(prepareVO.getPaymentNo());
		prepareVO.setTid(paymentDto.getPaymentTid());
		
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", kakaoAk);
		headers.add("Content-type", contentType);
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", cid);
		body.add("tid", prepareVO.getTid());
		body.add("cancel_amount", String.valueOf(prepareVO.getCancel_amount()));
		body.add("cancel_tax_free_amount", String.valueOf(prepareVO.getCancel_tax_free_amount()));
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
		
		//[6] 전송
		KakaoPayCancelVO cancelVO = 
				template.postForObject(uri, entity, KakaoPayCancelVO.class);
		log.debug("cancelVO = {}", cancelVO);
		
		//데이터베이스 상태를 취소로 변경하는 코드
		paymentDao.cancel(prepareVO.getPaymentNo());
		
		return cancelVO;
	}
}



