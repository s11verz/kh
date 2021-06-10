<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글자길이 구현하기</title>
<script>
	function calc(){
		var input=document.querySelector("#user-input");
		var span=document.querySelector("#length");
		
		var text=input.value;
		var len=text.lenght;
		
		span.innerHTML=text;
	}
</script>
</head>
<body>
	<input type="text" id="user-input" oninput="calc();">
	<span id="length">0</span>
</body>
</html>