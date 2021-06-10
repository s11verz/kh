<%@page import="study.beans.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="study.beans.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 스타일링</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.row{
		margin:30px 0px;
	}
	.form-input{
		margin-top:10px;
	}
</style>
</head>
<body>
	<div class="container-500">
		<div class="row text-center"><h1>회원정보 입력</h1></div>
			<form action="memberInsert.kh">
			<div class="row">
				<label for="id-input">아이디</label>
				<input type="text" name="memberId" required id="id-input" class="form-input form-input-underline" autocomplete="off">
			</div>
			<div class="row">
				<label for="pw-input">비밀번호</label>
				<input type="password" name="memberPw" required placeholder="비밀번호" class="form-input form-input-underline">
				<input type="password" required placeholder="비밀번호 재확인" class="form-input form-input-underline">
			</div> 
			<div class="row">
				<label for="nickname-input">닉네임</label>
				<input type="text" name="memberNick" required id="nickname-input" class="form-input form-input-underline" autocomplete="off">
			</div>
			<div class="row">
				<label for="birth-input">생년월일</label>
				<input type="date" name="memberBirth" required id="birth-input" class="form-input form-input-underline" autocomplete="off">
			</div>
			<div class="row">
				<label for="phone-input">전화번호</label>
				<input type="tel" name="memberPhone" required id="phone-input" class="form-input form-input-underline" autocomplete="off">
			</div>
			<div class="row">
				<label for="email-input">이메일</label>
				<input type="email" name="memberEmail" id="email-input" class="form-input form-input-underline" autocomplete="off">
			</div>
			<div class="row">
				<input type="submit" value="가입" class="form-btn form-btn-positive">
			</div>
		</form>
	</div>
</body>
</html>