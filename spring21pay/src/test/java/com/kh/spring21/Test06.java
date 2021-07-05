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
import com.kh.spring21.vo.KakaoPayApprovePrepareVO;
import com.kh.spring21.vo.KakaoPayApproveVO;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

//Test04의 내용을 KakaoPayService로 옮긴 뒤 해당 기능이 잘 작동하는지 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@Slf4j
public class Test06 {
	
	@Autowired
	private PayService payService;
	
	@Test
	public void test() throws URISyntaxException {
		//카카오 결제 승인 요청
		KakaoPayApprovePrepareVO prepareVO = KakaoPayApprovePrepareVO.builder()
																	.tid("T2915485579753546278")
																	.partner_order_id("a9293304-a49f-4161-b5b2-59eaa240c3b3")
																	.partner_user_id("56e2abff-79af-4786-b46f-ff345977df5c")
																	.pg_token("4a8a03e273927da12c67")
																.build();
		KakaoPayApproveVO approveVO = payService.approve(prepareVO);
		log.debug("approveVO = {}", approveVO);
	}
	
}

