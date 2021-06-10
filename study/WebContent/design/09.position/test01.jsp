<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>position 속성 다루기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
/*
position: static - 앞 태그의 영향을 받아 기본 값 위치가 결정되면 수정 불가
position: relative - 앞 태그의 영향을 받지만 약간의 조정이 가능
position: absolute - 앞 태그의 영향을 받지 않음 
*/
body{
	height:5000px;
}
.a,.b,.c{
	width:150px;
	height:150px;
	border:1px solid black;
	position:fixed;
}
.a{
	background-color:#74b9ff;
	top:100px;
	left:100px;
	z-index:3;
}
.b{
	background-color:#ffeaa7;
	top:200px;
	left:200px;
	z-index:2;
}
.c{
	background-color:#fdcb6e;
	top:300px;
	left:300px;
	z-index:1;
}
</style>
</head>
<body>
	<div class="a"></div>
	<div class="b"></div>
	<div class="c"></div>
</body>
</html>