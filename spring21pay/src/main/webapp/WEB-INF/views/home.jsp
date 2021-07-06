<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 시스템</h1>

<h2>현재 상태 : ${not empty memberNo} , 회원 번호 : ${memberNo}</h2>

<h2><a href="member/login">로그인</a></h2>
<h2><a href="member/logout">로그아웃</a></h2>

<c:if test="${not empty memberNo}">
	<h2><a href="shop/">쇼핑하기</a></h2>
	<h2><a href="shop/history">지난 결제내역 보기</a></h2>
</c:if>
