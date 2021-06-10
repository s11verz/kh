<%@page import="home.beans.ProductDto"%>
<%@page import="home.beans.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ProductDao productDao = new ProductDao();
	List<ProductDto> productList = productDao.list();
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-900">

	<div class="row">
		<h1>상품 리스트</h1>
	</div>
	
	<div class="row text-right">
		<a href="productInsert.jsp" class="link-btn">상품 등록</a>
	</div>
	
	<div class="row">
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>상품분류</th>
					<th>판매가</th>
					<th>제조일</th>
					<th>유통기한</th>
				</tr>
			</thead>
			
			<tbody>
				<%for(ProductDto productDto : productList){ %>
				<tr>
					<!-- 표현식(Expression) : 화면에 자바값을 출력하기 위한 구문 -->
					<td><%=productDto.getNo()%></td>
					<td>
						<a href="productDetail.jsp?no=<%=productDto.getNo()%>">
							<%=productDto.getName()%>
						</a>
					</td>
					<td><%=productDto.getType()%></td>
					<td><%=productDto.getPrice()%></td>
					<td><%=productDto.getMade().substring(0, 10)%></td>
					<td><%=productDto.getExpire().substring(0, 10)%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<div class="row text-right">
		<a href="productInsert.jsp" class="link-btn">상품 등록</a>
	</div>
	
	<div class="row">
		<div class="pagination">
			<a href="#">&lt;</a>
			<a href="#">1</a>
			<a href="#">2</a>
			<a href="#">3</a>
			<a href="#">4</a>
			<a href="#">5</a>
			<a href="#">6</a>
			<a href="#">7</a>
			<a href="#">8</a>
			<a href="#">9</a>
			<a href="#">10</a>
			<a href="#">&gt;</a>
		</div>
	</div>
	
</div>
		
<jsp:include page="/template/footer.jsp"></jsp:include>