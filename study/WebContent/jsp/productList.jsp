<%@page import="study.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page import="study.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//스크립트릿(scriptlet) : JSP 페이지를 구성하기 위한 코드를 작성하는 영역
	ProductDao productDao = new ProductDao();
	List<ProductDto> productList = productDao.list();
%>

<!Doctype HTML>
<html>
	<head>
		<title>상품 목록</title>
	</head>
	<body>
		
		<h1>상품 리스트</h1>
		
		<table border="1" width="600">
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
					<td><%=productDto.getName()%></td>
					<td><%=productDto.getType()%></td>
					<td><%=productDto.getPrice()%></td>
					<td><%=productDto.getMade().substring(0, 10)%></td>
					<td><%=productDto.getExpire().substring(0, 10)%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
		
	</body>
</html>