package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

//목표 : 자바 코드를 이용하여 카카오페이에 준비 요청을 전송(서버 to 서버 통신)
@Slf4j
public class Test03 {

	@Test
	public void test() throws URISyntaxException {
		//카카오페이에서 요구하는 준비를 위한 요청 주소
		//POST /v1/payment/ready HTTP/1.1
		//Host: kapi.kakao.com
		//Authorization: KakaoAK {APP_ADMIN_KEY}
		//Content-type: application/x-www-form-urlencoded;charset=utf-8
		
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK f6db56456d7ddef31a08cc2d1735c190");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//[3] Http Body 생성(ex : 편지내용)
		String partner_order_id=UUID.randomUUID().toString();
		log.debug("partner_order_id={}",partner_order_id);
		
		String partner_user_id=UUID.randomUUID().toString();
		log.debug("partner_user_id={}",partner_user_id);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");//가맹점ID(사업자 제휴 시 발급, 테스트용 ID 사용)
		body.add("partner_order_id", UUID.randomUUID().toString());//판매자 구분 ID
		body.add("partner_user_id", UUID.randomUUID().toString());//구매자 구분 ID
		body.add("item_name", "강남 50평 아파트");//명세서에 표시될 구매 내역(다건 구매일 경우 ???외 ?건 형식)
		body.add("quantity", "3");//구매수량
		body.add("total_amount", "999900");//총 구매금액
		body.add("tax_free_amount", "0");//면세금액(없으면 0)
		
		body.add("approval_url", "http://localhost:8080/spring21/pay/success");//사용자 결제 성공시 신호를 받을 주소
		body.add("cancel_url", "http://localhost:8080/spring21/pay/cancel");//사용자 결제 취소시 신호를 받을 주소
		body.add("fail_url", "http://localhost:8080/spring21/pay/fail");//사용자 결제 실패시 신호를 받을 주소
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//[6] 전송
		//template.postForLocation(uri, entity);//단순 요청만(응답을 기대하지 않음)
//		Map map = template.postForObject(uri, entity, Map.class);//응답 후 JSON 수신
//		log.debug("map={}",map);
		
		KakaoPayReadyVO readyVO=template.postForObject(uri, entity, KakaoPayReadyVO.class);
		log.debug("readyVO={}",readyVO);
		log.debug("url={}",readyVO.getNext_redirect_pc_url());
		log.debug("tid={}",readyVO.getTid());
	}
	
}
