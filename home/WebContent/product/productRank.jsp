<%@page import="home.beans.ProductDto"%>
<%@page import="home.beans.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 	scriptlet(스크립트릿)
	
// 	준비
// 	begin과 end가 없어도 기본값을 부여하여 페이지가 나오도록 설정
	int begin, end;
	try{
		//plan A : 전달되는 데이터를 설정
		begin = Integer.parseInt(request.getParameter("begin"));
		end = Integer.parseInt(request.getParameter("end"));
	}
	catch(Exception e){
		//plan B : 기본값 설정
		begin = 1;
		end = 10;
	}
	
// 	계산
	ProductDao productDao = new ProductDao();
	List<ProductDto> productList = productDao.rank(begin, end);
	
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-900">

	<div class="row">
		<h1>상품 가격 검색</h1>
	</div>
	
	<div class="row">
		<form action="productRank.jsp">
			<fieldset>
				<legend>범위 설정</legend>
				
				<input type="number" name="begin" class="form-input form-input-inline"> 부터
				<input type="number" name="end" class="form-input form-input-inline"> 까지
				<input type="submit" value="보기" class="form-btn form-btn-inline form-btn-positive"> 
				
			</fieldset>
		</form>
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