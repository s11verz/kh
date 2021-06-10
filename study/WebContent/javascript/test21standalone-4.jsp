<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트가 주도하는 이벤트 설정</title>
<script>
	window.onload=function(){
		var btn=document.querySelector(".test-btn");
		btn.addEventListener("click",function(){
			window.alert("눌렀습니다111");
		});
	};
	window.addEventListener("load",function(){
		var btn=document.querySelector(".test-btn");
		btn.addEventListener("click",function(){
			window.alert("눌렀습니다222");
		});
	});
	
	
</script>
</head>
<body>
	<input type="button" value="클릭해보세요" class="test-btn" >
</body>
</html>