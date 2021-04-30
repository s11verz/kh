<%@page import="study.beans.ItemDto"%>
<%@page import="java.util.List"%>
<%@page import="study.beans.ItemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	ItemDao itemDao = new ItemDao();
	List<ItemDto> list = itemDao.list();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemList 테이블 꾸미기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
.table>thead{
background-color:#a29bfe;
}
.insert-btn{
text-size:10px;
background-color:#a29bfe;
color:white;
border:none;
padding:5px 0px;
border-radius:20px;


}
</style>
</head>
<body>


<div class="container-600">
	<div class="row text-center">
		<h1>Item List</h1>
	</div>
	<div class="row">
	<table class="text-center container-400 table table-border">
	
	<thead>
		<tr>
			<th>itemNo</th>
			<th>itemName</th>
			<th>itemPrice</th>
		</tr>
	</thead>
	
	<tbody>
		<% for(ItemDto itemDto : list){ %>
		<tr>
			<td><%=itemDto.getItemNo()%></td>
			<td>
<%-- 		<a href="/study/jsp/itemDetail.jsp?itemNo=<%=itemDto.getItemNo()%>"> --%>
				<a href="itemDetail.jsp?itemNo=<%=itemDto.getItemNo()%>">
					<%=itemDto.getItemName()%>
				</a>
			</td>
			<td><%=itemDto.getItemPrice()%></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<button type="button" onclick="location.href='/study/jsp/itemInsert.jsp'" class="insert-btn container-100">아이템 등록</button>
<!-- <h4 class="insert text-center"><a href="/study/jsp/itemInsert.jsp">아이템등록</a></h4> -->
<!-- <h4><a href="itemInsert.jsp">아이템등록(상대경로)</a></h4> -->
</div>

</body>
</html>