<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>float 이해하기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.multi-container{
		border:1px dotted black;
		float:left;
		width:50%;
	}
	.wall{
		clear:both;
	}
	.float-container::after{
		content:"안녕하세요";
		display:block;
		clear:both;
		
	}
</style>
</head>
<body>
	<div style= "background-color:yellow;">테스트 코드1</div>
	
	<div class="float-container">
		<div class="multi-container">111</div>
		<div class="multi-container">222</div>
	</div>
	
	<div class="wall"></div>
	<div style= "background-color:gray;">테스트 코드2</div>
</body>
</html>