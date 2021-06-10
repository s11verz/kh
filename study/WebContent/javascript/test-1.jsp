<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function checkPhone(){
		var regex=/^0[0-9]{1,2}-[0-9]{3,4}-[0-9]{4}$/;
		var input=document.querySelector("input[name=phone]");
		var phone=input.value;
		var span=document.querySelector("input[name=phone]+span");
		if(!regex.test(phone)){
			window.alert("전화번호 형식을 확인하세요");
			document.getElementById("phone-input").value="";
			
		}
	}
	function count(filed){
		var chkbox=document.getElementsByName("hobby");
		var num=0;
	
		for(var i=0;i<chkbox.length;i++){
			if(chkbox[i].checked){
				num++;
			}
		}
		
		if(num<2){
			window.alert("취미는 2개 이상 선택하세요")
			e.preventDefault();
		}
	}
 
	
</script>
</head>
<body>
	<form action="result.html">
		<label>아이디</label>
		<input type="text" name="id" id="id-input" required><br><br>
		<label >이름</label>
		<input type="text" name="name" id="name-input" required><br><br>
		<label>취미</label>
		<input type="checkbox" name="hobby" value="피아노" onclick="count(this);">피아노
		<input type="checkbox" name="hobby" value="게임" onclick="count(this);">게임
		<input type="checkbox" name="hobby" value="테니스" onclick="count(this);">테니스
		<input type="checkbox" name="hobby" value="등산" onclick="count(this);">등산<br><br>
		<label for="phone-input">전화번호</label>
		<input type="text" name="phone" id="phone-input" required onblur="checkPhone();"><br><br>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</form>
</body>
</html>