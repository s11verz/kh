<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="productDto" items="${list }">
	<div>
		${productDto.no}
		${productDto.name}
		${productDto.type}
		${productDto.price}
		${productDto.made}
		${productDto.expire}
		
	</div>
</c:forEach>
