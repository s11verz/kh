<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	100을 n이라는 이름으로 저장한 뒤 10씩 증가시키면서 3번 출력해보세요(110, 120, 130)
 -->
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="n" value="100"></c:set>
<h1>n = ${n}</h1>

<c:set var="n" value="${n+10}"></c:set>
<h1>n = ${n}</h1>

<c:set var="n" value="${n+10}"></c:set>
<h1>n = ${n}</h1>

<c:set var="n" value="${n+10}"></c:set>
<h1>n = ${n}</h1>

<c:remove var="n"/>
<h1>n = ${n}</h1>
