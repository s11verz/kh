package com.kh.spring21.service;

import java.net.URISyntaxException;

import com.kh.spring21.vo.KakaoPayApprovePrepareVO;
import com.kh.spring21.vo.KakaoPayApproveVO;
import com.kh.spring21.vo.KakaoPayReadyPrepareVO;
import com.kh.spring21.vo.KakaoPayReadyVO;

public interface PayService {
	//결제 준비 요청
	KakaoPayReadyVO ready(KakaoPayReadyPrepareVO kakaoPayReadyPrepareVO) throws URISyntaxException;
	//결제 승인 요청
	KakaoPayApproveVO approve(KakaoPayApprovePrepareVO kakaoPayApprovePrepareVO) throws URISyntaxException;
}