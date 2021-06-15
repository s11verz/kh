<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="itemDto" items="${list}">
	<h3>${itemDto.itemName} / ${itemDto.itemPrice}원</h3>
</c:forEach>