<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 표시 문제</title>
	<script>
		window.addEventListener("load", function(){
			//비밀번호 입력창 뒤에 있는 버튼에 이벤트를 설정
			var btn = document.querySelector("input[name=memberPw] + input[type=button]");
			btn.addEventListener("click", function (){
				//this : 이벤트가 설정된 주인공(여기서는 버튼)
				//var input = document.querySelector("input[name=memberPw]");
				var input = this.previousElementSibling;//앞에 있는 요소
				if(this.value === "표시"){
					input.type = "text";
					this.value = "숨김";
				}
				else{
					input.type = "password";
					this.value = "표시";
				}
			});
		});
	</script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
	<style>
	
	</style>
</head> 
<body>
	<input type="text" name="memberPw" placeholder="비밀번호 입력" class="form-input form-input-inline">
	<input type="button" value="표시" class="form-btn form-btn-inline form-btn-normal">
</body>
</html>
