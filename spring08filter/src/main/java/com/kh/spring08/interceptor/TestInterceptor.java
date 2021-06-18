package com.kh.spring08.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *	인터셉터(Interceptor)
 *	- DispatcherServlet의 부분작업들을 감시할 수 있는 도구
 *	- interface HandlerIntercepter를 상속받거나
 *	- class HandlerInterceptorAdapter를 상속받아 구현한다(비추천)
 *
 *	- preHandle : 컨트롤러 호출 전 시점을 간섭(감시)할 수 있는 메소드
 *	- postHandle : 컨트롤러 호출 후 시점을 간섭(감시)할 수 있는 메소드
 *	- afterCompletion : 모든 처리의 완료 후 시점을 간섭(감시)할 수 있는 메소드
 */

public class TestInterceptor implements HandlerInterceptor{
//public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 실행");
		System.out.println(handler);//처리대상(메소드)
		
		//상황 : kh라는 파라미터가 있으면 통과 없으면 차단(403)
		if(request.getParameter("kh") != null) {
			return true;//가던길 가라(통과)
		}
		else {
			response.sendError(403);
			return false;//가던길 가지마라(차단)
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 실행");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 실행");
		System.out.println(handler);
		System.out.println(ex);
	}
	
}

