<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>상품 목록</h1>

<c:forEach var="productDto" items="${list}">
	<h2>
		<a href="detail/${productDto.no}">
			${productDto.name}(${productDto.price}원)
		</a>
	</h2>
</c:forEach>