package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.vo.KakaoPaySearchVO;

import lombok.extern.slf4j.Slf4j;

//목표 : 카카오페이 결제 내역 조회 기능 구현
//GET/POST /v1/payment/order HTTP/1.1
//Host: kapi.kakao.com
//Authorization: KakaoAK {APP_ADMIN_KEY}
//Content-type: application/x-www-form-urlencoded;charset=utf-8
@Slf4j
public class Test07 {
	
	@Test
	public void test() throws URISyntaxException {
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 57eb967939a6425801f4006702a31ebc");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME");
		body.add("tid", "T2915509764714390512");
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//[6] 전송
		//Map map = template.postForObject(uri, entity, Map.class);//응답 후 JSON 수신
		//log.debug("map = {}", map);
		
		KakaoPaySearchVO searchVO = template.postForObject(uri, entity, KakaoPaySearchVO.class);
		log.debug("searchVo = {}", searchVO);
	}
	
}
