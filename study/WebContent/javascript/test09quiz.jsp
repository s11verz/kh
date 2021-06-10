<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>닉네임 글자 수 검사</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
	<script>
		function checkNick(){
			//준비물 : input 태그 , span 태그
			//a + b 는 a 뒤에 있는 b를 말한다(바로 뒤에 있어야 함)
			//a ~ b 는 a 뒤에 있는 모든 b를 말한다
			var input = document.querySelector("input[name=memberNick]");
			var span = document.querySelector("input[name=memberNick] + span");
			
			if(input.value.length >= 2 && input.value.length <= 8){
				span.textContent = "올바른 닉네임입니다";
			}
			else{
				span.textContent = "닉네임은 2~8자 이내로 작성하세요";
			}
		}
	</script>
</head>
<body>
	<div class="container-600">
		<form action="?" method="post">
			<div class="row text-left">
				<label>닉네임 입력</label>
<!-- 				<input type="text" name="memberNick" oninput="checkNick();" class="form-input"> -->
				<input type="text" name="memberNick" onblur="checkNick();" class="form-input">
				<span></span>
			</div>
		</form>
	</div>
		
		 
	
</body>
</html>