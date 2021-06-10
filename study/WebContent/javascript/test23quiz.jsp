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
<script>
	window.addEventListener("load", function(){
		var input=document.querySelector("input[name=memberNick]");
		input.addEventListener("input", function(){
			var regex=/^[가-힣]{2,10}$/;
			this.classList.remove("correct","incorrect");
			if(this.value){
				if(regex.test(this.value)){
					this.classList.add("correct");
				}else{
					this.classList.add("incorrect");
				}
			}
		});
	});
</script>
</head>
<body>
	<input type="text" name="memberNick" placeholder="닉네임 입력" class="form-input">
</body>
</html>