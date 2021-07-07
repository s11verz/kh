
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>상품 목록</h1>

<form action="buy2" method="post">

<c:forEach var="productDto" items="${list}">
	<h2>
		<!-- 묶음 결제용 체크박스 추가 -->
		<input type="checkbox" name="no" value="${productDto.no}">
		
		<a href="detail/${productDto.no}">
			${productDto.name}(${productDto.price}원)
		</a>
	</h2>
</c:forEach>

<input type="submit" value="묶음 결제하기">

</form>