<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임 검사</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<style>
	.form-input.correct{
		border:1px solid blue;
	}
	.form-input.incorrect{
		border:1px solid red;
	}
</style>
<script src="test23.js"></script>
</head>
<body>
	<input type="text" name="memberNick" placeholder="닉네임 입력" class="form-input">
</body>
</html>