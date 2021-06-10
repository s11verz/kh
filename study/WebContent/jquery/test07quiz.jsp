<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jQuery</title>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
	<style>
	
	</style>
	
<!-- 	개발할 때는 uncompressed 버전, 개발 후 배포시에는 compressed(minify) 버전을 사용 -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
	<script>
		$(function(){
			//비밀번호 입력창에 input/blur 이벤트를 설정
			$("#pw-input").on("input", function(){
				//this == 비밀번호 입력창
				var password = $(this).val();//this.value
				var regex = /^[a-zA-Z0-9]{8,16}$/;
				if(regex.test(password)){
					//var span = $("#pw-input + span");
					//var span = this.nextElementSibling;
					
					//this.nextElementSibling.textContent = "올바른 비밀번호 형식입니다";
					$(this).next("span").text("올바른 비밀번호 형식입니다");
					//this.nextElementSibling.style.color = "green";
					$(this).next("span").css("color", "green");
				}
				else{
					$(this).next("span").text("비밀번호는 영문,숫자 8~16자 이내로 작성하세요");
					$(this).next("span").css("color", "red");
				}
			});
			
			//비밀번호 확인창에 input/blur 이벤트를 설정
			$("#pw-re-input").on("input", function(){
				//this == 비밀번호 확인창
				
				var password = $("#pw-input").val();
				var passwordRe = $(this).val();
				
				//둘 중 하나라도 "부정적인 값"이라면 글자를 지운다(부정적인 값 == 빈 문자열)
				if(!password || !passwordRe){
					$(this).next("span").text("");
				}
				else if(password === passwordRe){
					$(this).next("span").text("비밀번호가 일치합니다");
					$(this).next("span").css("color", "green");
				}
				else{
					$(this).next("span").text("비밀번호가 일치하지 않습니다");
					$(this).next("span").css("color", "red");
				}
			});
		});
	</script>
</head>
<body>
	<div class="container-600">
		<div class="row text-center">
			<h2>회원 가입</h2>
		</div>
		<form action="??" method="post">
			<div class="row">
				<label for="pw-input">비밀번호</label>
				<input id="pw-input" type="password" name="memberPw" class="form-input form-input-underline">
				<span></span>
			</div>
			<div class="row">
				<label for="pw-re-input">비밀번호 재확인</label>
				<input id="pw-re-input" type="password" class="form-input form-input-underline">
				<span></span>
			</div>
			<div class="row">
				<input type="submit" value="가입" class="form-btn form-btn-positive">
			</div>
		</form>
	</div>
</body>
</html>