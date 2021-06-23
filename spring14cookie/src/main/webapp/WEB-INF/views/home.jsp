<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<h1>쿠키 예제</h1>

<!-- 약속
	쿠키 이름: visit
	쿠키 값: 날짜 -->
<h2>visit : ${cookie.visit}</h2>
<h2>visit : ${cookie["visit"] }</h2>
<h2>visit : ${cookie.visit.value }</h2>
<h2>visit : ${cookie["visit"].value }</h2>

<h1><a href="create">쿠키 생성</a></h1>
 <h1><a href="delete">쿠키 삭제</a></h1>
 
 <c:choose>
 	<c:when test="${cookie.visit == null}">
 		<h2>쿠키가 없습니다</h2>
 	</c:when>
 	<c:otherwise>
 		<h2>쿠키가 있습니다</h2>
 	</c:otherwise>
 </c:choose>
