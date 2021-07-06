<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>지난 결제 내역 조회</h1>

<c:forEach var="paymentDto" items="${list}">
	<h1>
		[ 
		<a href="historyDetail?paymentNo=${paymentDto.paymentNo}">${paymentDto.paymentNo}</a> 
		]
		상품번호 : ${paymentDto.paymentProduct},
		상태 : ${paymentDto.paymentStatus}		
	</h1>
</c:forEach>