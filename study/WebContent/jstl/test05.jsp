<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL 반복 처리
	1. c:forEach - 일반적인 반복문
	2. c:forTokens - 구분자(delimiter)를 이용한 반복문
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 일반적인 반복문(구간, 횟수) --%>
<c:forEach var="i" begin="1" end="10" step="1">
	<h2>i = ${i}</h2>
</c:forEach>

<%-- 확장 반복문 --%>

<%-- int[] numbers = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; --%>
<c:set var="numbers" value="10,20,30,40,50,60,70,80,90,100"></c:set>

<%--
	for(int n : number){
		System.out.println(n);
	}
 --%>
<c:forEach var="n" items="${numbers}">
	<h2>n = ${n}</h2>
</c:forEach>


<c:forTokens var="n" items="${numbers}" delims=",">
	<h2>n = ${n}</h2>
</c:forTokens>



