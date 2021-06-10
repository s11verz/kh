<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>이용약관 동의</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
	<style>
		
	</style>
	<script>
		window.addEventListener("load", function(){
			//첫 번째 체크박스에 이벤트 설정
			
			//var check1 = document.querySelector("#agree1");
			//check1.addEventListener("input", function(){});
			document.querySelector("#agree1").addEventListener("input", function(){
				//this : 첫 번째 체크박스
				agreeAll();
			})
			
			//두 번째 체크박스에 이벤트 설정
			document.querySelector("#agree2").addEventListener("input", function(){
				//this : 두 번째 체크박스
				agreeAll();
			});
			
			//세 번째 체크박스에 이벤트 설정
			document.querySelector("#agree3").addEventListener("input", function(){
				//this : 세 번째 체크박스
				agreeAll();
			});
		});
		
		function agreeAll(){
			var agree1 = document.querySelector("#agree1");
			var agree2 = document.querySelector("#agree2");
			var agree3 = document.querySelector("#agree3");
			
			//전체동의 = 1번동의 && 2번동의 && 3번동의
			var agree = agree1.checked && agree2.checked && agree3.checked;
			
			//전체동의가 이루어진 경우 비활성화 해제, 아닌 경우 비활성화 설정(=전체동의와 반대로 비활성화 설정)
			var nextBtn = document.querySelector("#next-btn");
			nextBtn.disabled = !agree;
		}
	</script>
</head>
<body>
	<div class="container-600">
		<div class="row">
			<input type="checkbox" id="agree-all"> 
			<label for="agree-all">전체 이용약관에 동의합니다</label>
		</div>
		<div class="row">
			<textarea class="form-input">약관1</textarea>
			<input type="checkbox" id="agree1"> 
			<label for="agree1">동의합니다</label>
		</div>
		<div class="row">
			<textarea class="form-input">약관2</textarea>
			<input type="checkbox" id="agree2"> 
			<label for="agree2">동의합니다</label>
		</div>
		<div class="row">
			<textarea class="form-input">약관3</textarea>
			<input type="checkbox" id="agree3"> 
			<label for="agree3">동의합니다</label>
		</div>
		<div class="row">
			<input type="button" value="다음 단계로 진행" class="form-btn" disabled id="next-btn">
		</div>
	</div>
</body>
</html>