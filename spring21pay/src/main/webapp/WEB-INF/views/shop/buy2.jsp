<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 확인 페이지(buy2.jsp)</h1>

<form action="confirm2" method="post">

<!-- varStatus는 반복과 관련된 상태값을 관리하는 변수를 설정할 수 있다 -->
<c:forEach var="productDto" items="${list}" varStatus="status">
	<input type="hidden" name="chunk[${status.index}].no" value="${productDto.no}">
	<div>
		<b>${productDto.name}</b>
		(${productDto.price}원)
		
		<!-- 수량입력창을 추가 -->
		수량 : 
		<input type="number" name="chunk[${status.index}].quantity" value="1" min="1">		
	</div>
</c:forEach>

<input type="submit" value="최종 결제 요청">

</form>


