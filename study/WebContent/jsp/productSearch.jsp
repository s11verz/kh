<%@page import="study.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="study.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//준비
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	
	//계산
	//= type과 keyword가 둘 다 있으면 검색 , 아니면 목록
	//목록 : type == null || keyword == null
	//검색 : type != null && keyword != null
	
	ProductDao productDao = new ProductDao();
	//List<ProductDto> productList = 목록 또는 검색결과;
	List<ProductDto> productList;
	if(type == null || keyword == null){//목록
		productList = productDao.list();
	}
	else{
		productList = productDao.search(type, keyword);
	}
%>

<!Doctype HTML>
<html>
	<head>
		<title>상품 목록</title>
	</head>
	<body>
		
		<h1>상품 리스트</h1>
		
		<!-- 검색창 추가 -->
<!-- 		<form action="/study/jsp/productSearch.jsp"> -->
		<form action="productSearch.jsp">
		
			<fieldset>
				<legend>검색 설정</legend>
				
<!-- 				<input type="text" name="type"> -->
				<select name="type">
					<option value="name">상품명</option>
					<option value="type">상품분류</option>
				</select>
				<input type="text" name="keyword">
				<input type="submit" value="검색">
			</fieldset>
		
		</form>
		
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
					<td>
<%-- 				<a href="/study/jsp/productDetail.jsp?no=<%=productDto.getNo()%>"> --%>
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
		
	</body>
</html>