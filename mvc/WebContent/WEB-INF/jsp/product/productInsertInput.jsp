<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>상품등록</h1>

<form action="productInsert.kh" method="post">
	<input type="text" name="name"><br><br>
	<input type="text" name="type"><br><br>
	<input type="text" name="price"><br><br>
	<input type="date" name="made"><br><br>
	<input type="date" name="expire"><br><br>
	<input type="submit" value="등록">
</form>