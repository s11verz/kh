<%@page import="home.beans.ItemDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.ItemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ItemDao itemDao =new ItemDao();
List<ItemDto> itemList=itemDao.list();
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-600">
	<div class="row">
		<h2>아이템 목록</h2>
	</div>
	
	
	
	<div class="row">
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<th>아이템 번호</th>
					<th>아이템 이름</th>
					<th>판매가</th>
				</tr>
			</thead>
			<tbody>
				<%for(ItemDto itemDto:itemList){%>
				<tr>
					<td><%=itemDto.getItemNo() %></td>
					<td>
						<a href="itemDetail.jsp?itemNo=<%=itemDto.getItemNo()%>">
							<%=itemDto.getItemName()%>
						</a>
					</td>
					<td><%=itemDto.getItemPrice() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<div class="row text-right">
		<a href="itemInsert.jsp" class="link-btn">아이템 등록</a>
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

<jsp:include page="/template/footer.jsp" ></jsp:include>