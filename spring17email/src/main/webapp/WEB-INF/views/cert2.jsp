<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>인증번호 입력 페이지</h1>

<form action="cert2" method="post">
	<input type="hidden" name="email" value="${param.email}">
	<input type="text" name="no" placeholder="인증번호 입력" required>
	<input type="submit" value="확인">
</form>