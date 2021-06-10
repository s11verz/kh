<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<form action="/memberJoin.do" method="post" id="form">
	<label>회원 ID:</label><input type="text" name="id" placeholder="ID를 입력하세요" oninput="idCheck()" required><span></span><br>
	<label>회원 PW:</label><input type="password" name="pw" id="pw1" class="pw" placeholder="PW를 입력하세요" oninput="pwCheck()" required><span></span><br>
	<label>회원 PW 확인:</label><input type="password" id="pw2" class="pw" placeholder="PW를 입력하세요" required oninput="pwRecheck()"><span></span>
		<br>
	<label>회원 이름:</label><input type="text" name="name" placeholder="이름을 입력하세요" oninput="nameCheck()" required><span></span><br>
	<label>성별:</label>
		<input type="radio" name="gender" value="남" checked="checked">남
		<input type="radio" name="gender" value="여">여
	<br>
		
	<input type="submit" value="회원가입">
	<input type="reset" value="취소">
</form>

<script>
const formtag=document.getElementById("form");
	function handleSubmit(e){
		e.preventDefault;
	}
	function idCheck(){
		var regex=/^[a-z][a-z0-9]{3,9}$/;
		var input=document.querySelector("input[name=id]");
		var id=input.value;
		var span=document.querySelector("input[name=id]+span");
		
		if(regex.test(id)){
			span.textContent="올바른 아이디 형식입니다";
		}else{
			span.textContent="영어 소문자, 숫자로만 4~10자로 입력해주세요";
		}
	}
	function pwCheck(){
		var regex=/^[a-zA-Z0-9]{8,12}$/;
		var input=document.querySelector("input[name=pw]");
		var pw=input.value;
		var span=document.querySelector("input[name=pw]+span");
		if(regex.test(pw)){
			span.textContent="올바른 비밀변호 형식입니다";
		}else{
			span.textContent="소문자, 대문자, 숫자로 8~12글자로 입력해주세요"
		}
	}
	function nameCheck(){
		var regex=/^[가-힣]{2,5}$/;
		var input=document.querySelector("input[name=name]");
		var name=input.value;
		var span=document.querySelector("input[name=name]+span");
		if(regex.test(name)){
			span.textContent="올바른 이름 형식입니다";
		}else{
			span.textContent="한글로 2~5글자로 입력해주세요"
		}
	}
	function pwRecheck(){
		var pwd1=document.querySelector("input[id=pw1]");
		var pwd2=document.querySelector("input[id=pw2]");
		var pw_check1=pwd1.value;
		var pw_check2=pwd2.value;
		var span=document.querySelector("input[id=pw2]+span")
		if(pw_check1==pw_check2){
			span.textContent="비밀번호가 일치합니다";
		}else{
			span.textContent="비밀번호가 일치하지 않습니다";
		}
	}
	

</script>
</body>
</html>