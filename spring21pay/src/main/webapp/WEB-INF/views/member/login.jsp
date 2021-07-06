<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>로그인</h1>

<form action="login" method="post">
	<input type="text" name="memberId" placeholder="아이디" required>
	<br><br>
	<input type="password" name="memberPw" placeholder="비밀번호" required>
	<br><br>
	<input type="submit" value="로그인">
</form>