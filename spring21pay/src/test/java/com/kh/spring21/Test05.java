package com.kh.spring21;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring21.service.PayService;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

//Test03의 내용을 KakaoPayService로 옮긴 뒤 해당 기능이 잘 작동하는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test05 {
	
	@Autowired
	private PayService payService;
	
	@Test
	public void test() throws URISyntaxException {
		//카카오 결제 준비 요청
		KakaoPayReadyPrepareVO prepareVO = KakaoPayReadyPrepareVO.builder()
																.partner_order_id(UUID.randomUUID().toString())
																.partner_user_id(UUID.randomUUID().toString())
																.item_name("자바 평생 무료 수강권")
																.quantity(1)
																.total_amount(500000)
																//.tax_free_amount(0)
															.build();
		KakaoPayReadyVO readyVO = payService.ready(prepareVO);
		log.debug("readyVO = {}", readyVO);
	}
	
}







