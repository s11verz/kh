<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	JSP에서 자주 사용하는 코드 중에는 다음 저장소에 접근하는 코드들이 있다.
	- pageContext : 페이지 영역(페이지 내장객체가 존재)
	- request : 요청 영역
	- session : 사용자(브라우저) 영역
	- application : 전체 서버 영역(서블릿/필터 존재)
	
	EL에는 위의 저장소들에 쉽게 접근할 수 있도록 지원되는 "내장객체"가 존재한다
	- pageContext <----> pageScope
	- request <----> requestScope
	- session <----> sessionScope
	- application <----> applicationScope
	
	추가적으로 이름이 겹치지 않는다면 "내장객체" 명도 생략이 가능하다
--%>

<%
	//테스트 데이터 첨부
	pageContext.setAttribute("c", 300);
	request.setAttribute("a", 100);
	session.setAttribute("b", "hello");
	application.setAttribute("d", 500);
%>

<h1>a = <%=request.getAttribute("a")%></h1>
<h1>a = ${requestScope.a}</h1>
<h1>a = ${a}</h1>

<h1>b = <%=session.getAttribute("b")%></h1>
<h1>b = ${sessionScope.b}</h1>
<h1>b = ${b}</h1>

<h1>회원번호 = <%=session.getAttribute("memberNo")%></h1>
<h1>회원번호 = ${sessionScope.memberNo}</h1>
<h1>회원번호 = ${memberNo}</h1>

<h1>로그인 = <%=session.getAttribute("memberNo") != null%></h1>
<h1>로그인 = ${memberNo != null}</h1>
<h1>로그인 = ${not empty memberNo}</h1>

<!-- Q : pageContext와 application에 저장한 데이터를 EL로 출력 -->
<h1>c = ${pageScope.c}</h1>
<h1>c = ${c}</h1>

<h1>d = ${applicationScope.d}</h1>
<h1>d = ${d}</h1>





