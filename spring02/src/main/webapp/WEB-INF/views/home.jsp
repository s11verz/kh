<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메인페이지</h1>

<a href="dice">주사위 뽑기</a>

<br><br>

<form action="plus" method="post">
	<input type="number" name="a" value="0" required>
	+
	<input type="number" name="b" value="0" required>
	=
	<input type="submit" value="결과">
	
</form>