<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL의 특징
	
	= 기본적인 웹의 데이터에 접근하기 위한 "내장객체"가 존재한다.
	
	= 파라미터에 접근하려면 param 이라는 내장객체를 사용하도록 구현되어 있다.
	
	= null을 절대 화면에 출력하지 않는다.
 --%>

<form action="test02.jsp">
	<input type="text" name="key" placeholder="검색어 입력" required value="${param.key}">
	<input type="submit" value="검색">
</form>

<h2>검색어 : <%=request.getParameter("key")%></h2>
<h2>검색어 : ${param.key}</h2>
