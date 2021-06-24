package com.kh.spring16.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
public class PlanServiceImple implements PlanService{

	//@Scheduled(initialDelay = 5000, fixedRate = 1000) //'주기적인 작업'임을 알림 
	//initialDelay : 시작 후 딜레이(ms)
	//fixedRate : 실행 주기(ms)
	//cron : 실행 주기에 관련된 식 - 좌측부터 초, 분, 시, 일, 월, 요일, 연도  
	@Override
	public void work1() {
		log.debug("work1 실행");
	}
	
	//@Scheduled(cron="* * * * * *") //매초 
	//@Scheduled(cron="0 * * * * *") //매분 0초 
	//@Scheduled(cron="0 0 * * * *") //매시 정각 
	//@Scheduled(cron="* * * * * 4") //목요일 매시 정각 
	//@Scheduled(cron="* * * * * thu") //목요일 매시 정각 
	//@Scheduled(cron="*/5 * * * * *") //매 5초마다 
	//@Scheduled(cron="0,30 * * * * *") //매 0초, 30초 
	//@Scheduled(cron="0-10 * * * * *") //매 0초~10초 
	//@Scheduled(cron="0 0 9 * * *") //매일 아침 9시  
	//@Scheduled(cron="0 0 14 25 * *") //매월 25일 오후 2시  
	@Scheduled(cron="* * * ? * 4L") //매월 마지막 목요일  
	@Override
	public void work2() {
		log.debug("work2 실행");
	}
}
