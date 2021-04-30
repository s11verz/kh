<%@page import="study.beans.ProductDto"%>
<%@page import="study.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	ProductDao productDao = new ProductDao();
	ProductDto productDto = productDao.get(no);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
</head>
<body>
	<h1>상품 상세정보</h1>
	
	<table border="1" width="350">
		<tr>
			<th width="25%">상품번호</th>
			<td><%=productDto.getNo()%></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><%=productDto.getName()%></td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td><%=productDto.getType()%></td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><%=productDto.getPrice()%></td>
		</tr>
		<tr>
			<th>제조일자</th>
			<td><%=productDto.getMade()%></td>
		</tr>
		<tr>
			<th>유통기한</th>
			<td><%=productDto.getExpire()%></td>
		</tr>
	</table>
	
	<h2><a href="#">수정하기</a></h2>
	<h2><a href="productDelete.kh?no=<%=no%>">삭제하기</a></h2>
	
</body>
</html>