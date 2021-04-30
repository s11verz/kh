<%@ page import="study.beans.ItemDto"%>
<%@ page import="java.util.List"%>
<%@ page import="study.beans.ItemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ItemDao itemDao = new ItemDao();
	List<ItemDto> list = itemDao.list();
%>

<h4><a href="/study/jsp/itemInsert.jsp">아이템등록(절대경로)</a></h4>
<h4><a href="itemInsert.jsp">아이템등록(상대경로)</a></h4>

<table border="1">
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

