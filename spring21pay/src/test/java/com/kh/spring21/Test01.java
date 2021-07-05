package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

//목표 : 자바 코드를 이용하여 카카오페이에 준비 요청을 전송(서버 to 서버 통신)
@Slf4j
public class Test01 {

	@Test
	public void test() throws URISyntaxException {
		//서버에서 서버로 요청을 보내기 위해서는 다음 방법들이 존재한다.
		//1. HttpUrlConnection 이용(java.net 패키지)
		//2. RestTemplate 이용(spring에서 제공)
		
		//[1] 요청 도구 생성
		RestTemplate template = new RestTemplate();
		
		//[2] Http Header 생성(ex : 편지봉투)
		HttpHeaders headers = new HttpHeaders();
		headers.add("이름", "데이터");
		
		//[3] Http Body 생성(ex : 편지내용)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("이름", "데이터");
		
		//[4] Http Header / Body 합성
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//[5] 목적지 주소 작성
		URI uri = new URI("주소");
		
		//[6] 전송
		template.postForLocation(uri, entity);//단순 요청만(응답을 기대하지 않음)
		//? = template.postForObject(uri, entity, 응답형태);//응답 후 JSON 수신
	}
	
}