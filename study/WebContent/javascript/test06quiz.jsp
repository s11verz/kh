<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 입력창 문제</title>
<script>
	function test1(){
		var target=document.querySelector("input[name=memberPw]");
		target.type="test";
	}
	function test2(){
		var target=document.querySelector("input[name=memberPw]");
		target.type="password";
	}
	function test3(){
		var btn=document.querySelector(".btn");
		if(btn.value=="표시"){
			test1();
			btn.value="숨김";
		}else{
			test2();
			btn.value="표시";
		}
	}
</script>
</head>
<body>
	<form>
		<input type="password" name="memberPw">
		<input type="button" value="표시" onclick="test1()">
		<input type="button" value="숨김" onclick="test2()">
		<input type="button" value="표시" onclick="test3()" class="btn">
	</form>
</body>
</html>