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
		<h2>아이템 정보입력</h2>
	</div>
	<form action="itemInsert.kh" method="post">
		<div class="row text-left">
			<label>아이템 이름</label>
			<input type="text" name="itemName" required class="form-input">
		</div>
		<div class="row text-left">
			<label>아이템 가격</label>
			<input type="text" name="itemPrice" required class="form-input">
		</div>
		<div class="row">
			<input type="submit" value="등록" class="form-btn form-btn-normal">
		</div>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>