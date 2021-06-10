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
	
	//자바스크립트
	/* window.addEventListener("loae",function(){
		var h1=document.querySelectorAll("h1");
		for(var i=0;i<h1.length;i++){
			h1[i].style.color="red";
		}
	}); */
	
	//jQuery
	//$().ready(function(){
	$(function(){
		$("h1").css("color","red");
	});
</script>
</head>
<body>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
</body>
</html>