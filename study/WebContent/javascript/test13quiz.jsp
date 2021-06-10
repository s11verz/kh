<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력창 클래스 스타일링</title>
<script>
	function nicknameCheck(){
		var regex=/^[가-힣]{2,10}$/;
		var nicknameInput=document.querySelector(".user-input");
		
		nicknameInput.classList.remove("correct","incorrect");
		if(nicknameInput.value){
		if(regex.test(nicknameInput.value)){
			nicknameInput.classList.add("correct");
		}else{
			nicknameInput.classList.add("incorrect");
		}
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.form-input.correct{
		background-image:url("../image/correct.png");
		background-repeat:no-repeat;
		background-size:25px;
		background-position:right;
	}
	.form-input.incorrect{
		background-image:url("../image/incorrect.png");
		background-repeat:no-repeat;
		background-size:25px;
		background-position:right;
	}
</style>
</head>
<body>
	<input type="text" class="user-input" placeholder="닉네임 입력" oninput="nicknameCheck();"> 
</body>
</html>