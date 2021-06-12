<%@page import="study.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="study.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL을 이용한 객체 리스트 출력
--%>
<%
	//ex : 서블릿에서 작성한 코드라고 가정
	ProductDao productDao = new ProductDao();
	List<ProductDto> list = productDao.list();
	
	request.setAttribute("list", list);
%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="productDto" items="${list}">
	<div>
		${productDto.no}
		${productDto.name}
		${productDto.type}
		${productDto.price}
		${productDto.made}
		${productDto.expire}
	</div>
</c:forEach>

