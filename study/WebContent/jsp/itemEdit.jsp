<%@page import="study.beans.ItemDto"%>
<%@page import="study.beans.ItemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int itemNo=Integer.parseInt(request.getParameter("itemNo"));

	ItemDao itemDao=new ItemDao();
	ItemDto itemDto=itemDao.get(itemNo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 정보 수정</title>
</head>
<body>

<h1>아이템 정보 수정</h1>
<form action="itemEdit.kh" method="post">

번호: <input type="text" name="itemNo" value="<%=itemDto.getItemNo()%>"><br><br>
이름: <input type="text" name="itemName" value="<%=itemDto.getItemName()%>"><br><br>
가격: <input type="text" name="itemPrice" value="<%=itemDto.getItemPrice()%>"><br><br>

<input type="submit" value="수정">


</form>

</body>
</html>