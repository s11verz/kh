<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 최종 결제 확인 페이지 -->

<h1>결제 정보 확인</h1>

<ul>
	<li>상품번호 : ${productDto.no}</li>
	<li>상품이름 : ${productDto.name}</li>
	<li>상품분류 : ${productDto.type}</li>
	<li>상품가격 : ${productDto.price}</li>
	<li>제조일자 : ${productDto.made}</li>
	<li>유통기한 : ${productDto.expire}</li>
	<li>주문수량 : ${quantity}</li>
	<li>총 결제금액 : ${total_amount}</li>
</ul>

<form action="confirm" method="post">
	<input type="hidden" name="no" value="${productDto.no}">
	<input type="hidden" name="item_name" value="${productDto.name}">
	<input type="hidden" name="quantity" value="${quantity}">
	<input type="hidden" name="total_amount" value="${total_amount}">
	<input type="submit" value="결제하기">
</form>

