<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<style>
	.border{
		border: 1px solid black;
	}
</style>
<script>
	function goResult(){
		document.form-join.action="/result.html";
		document.form-join.method="post";
		document.form-join.submit();
	}
	function checkId(){
		var regex=/^[A-Z][A-Za-z0-9]{5,}$/;
		
		var input=document.querySelector("input[name=memberId]");
		var memberId=input.value;
		var span=document.querySelector("input[name=mamberId]+span");
		if(regex.test(memberId)){
			span.textContent="올바른 아이디 형식입니다.";
		}else{
			window.alert("5글자이상, 첫글자는 대문자이고 영문자, 숫자만 가능");
			delete memberId;
		}
	}
	function checkGender(){
		
	}
</script>
</head>
<body>
	<div class="container-600 ">
		<div class="border">
			<label onclick="document.getMemberId.focus()">아이디</label><input type="text" name="memberId" class="form-input" required onblur="checkId();"><br>
			<label>패스워드</label><input type="password" name="memberPw" class="form-input" required><br>
			<label>패스워드 확인</label><input type="password" class="form-input" required><br>
			<label>이름</label><input type="text" name="memberName" class="form-input" required><br>
			<label>성별</label>
			<label for="memberMale">남</label>
			<input type="radio" name="memberGender" class="form-input" onclick="checkGender()">
			<label for="memberFemale">여</label>
			<input type="radio" name="memberGender" class="form-input" onclick="checkGender()"><br>
			<label>이메일</label><input type="text" name="memberEmail" class="form-input" required><br>
			<form name="form-join"><input type="submit" value="회원가입" onclick="goResult()"></form>
			<form name="form-cancel"><input type="reset" value="취소"></form>
		</div>
	</div>
</body>
</html>​
