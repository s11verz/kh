<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>상품 상세</h1>

<ul>
	<li>상품번호 : ${productDto.no}</li>
	<li>상품이름 : ${productDto.name}</li>
	<li>상품분류 : ${productDto.type}</li>
	<li>상품가격 : ${productDto.price}</li>
	<li>제조일자 : ${productDto.made}</li>
	<li>유통기한 : ${productDto.expire}</li>
</ul>

<form action="${pageContext.request.contextPath}/shop/buy" method="post">
	<input type="hidden" name="no" value="${productDto.no}">
	<input type="number" name="quantity" value="1" min="1" required>
	<input type="submit" value="주문하기">
</form>


