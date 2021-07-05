package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Test04 {

	@Test
	public void test() throws URISyntaxException {
		//서버에서 서버로 요청을 보내기 위해서는 다음 방법들이 존재한다.
		//1. HttpUrlConnection 이용(java.net 패키지)
		//2. RestTemplate 이용(spring에서 제공)
		
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK f6db56456d7ddef31a08cc2d1735c190");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", "T2915474571752366472");//결제준비 응답정보에 포함된 TID 항목 값 
		body.add("partner_order_id", "7ad18758-3c2e-4809-9963-3a658edfca1c");//결제준비 요청정보에 포함된 PARTNER_ORDER_ID 항목 값 
		body.add("partner_user_id", "4d5ab4d5-902c-4cc5-8802-0bc1035400d8");//결제준비 요청정보에 포함된 PARTNER_USER_ID 항목 값 
		body.add("pg_token", "6c0195adee3c10b21aca");//결제 성공 시 파라미터로 전달되는 PG_TOKEN 값 
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//[6] 전송
		//template.postForLocation(uri, entity);//단순 요청만(응답을 기대하지 않음)
		//? = template.postForObject(uri, entity, 응답형태);//응답 후 JSON 수신
		KakaoPayReadyVO approveVO=template.postForObject(uri, entity, KakaoPayReadyVO.class);
		log.debug("approveVO={}",approveVO);
	}
	
}