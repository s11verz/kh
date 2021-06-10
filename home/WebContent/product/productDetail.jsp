<%@page import="home.beans.ProductDto"%>
<%@page import="home.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	ProductDao productDao = new ProductDao();
	ProductDto productDto = productDao.get(no);
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-700">
	<div class="row">
		<h1>상품 상세정보</h1>
	</div>
	
	<div class="row">
		<table class="table table-border table-hover">
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
	</div>
	
	<div class="row text-right">
		<a href="productEdit.jsp?no=<%=no%>" class="link-btn">상품 수정</a>
		<a href="productDelete.kh?no=<%=no%>" class="link-btn">상품 삭제</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>
    