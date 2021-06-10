<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$(".red-btn").click(function(){
			$(".target").css("color","red");
		});
		$(".blue-btn").click(function(){
			$(".target").css("color","blue");
		});
	});
</script>
</head>
<body>
	<button class="red-btn">빨강</button>
	<button class="blue-btn">파랑</button>
	<hr>
	<h1 class="target">Hello jQuery!</h1>
	<h1 class="target">Hello jQuery!</h1>
	<h1 class="target">Hello jQuery!</h1>
	<h1 class="target">Hello jQuery!</h1>
	<h1 class="target">Hello jQuery!</h1>
</body>
</html>