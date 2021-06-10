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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		document.querySelector(".test-btn").addEventListener("click",function(){
			window.alert("잘했어요(자바스크립트)");
		});
		$(".test-btn").on("click",function)
	});
</script>
</head>
<body>
	<button class="test-btn">눌러보세요!</button>
</body>
</html>