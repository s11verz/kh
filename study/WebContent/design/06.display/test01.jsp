<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display 속성 설정</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
/*
-display:block - 한줄에 하나만 (폭 임의로 설정 가능)
-display:inline - 한줄에 여러개 (폭 임의로 설정 가능)
-display:inline-block -  
*/
	div{
		width:200px;
		display:inline-block;
	}
</style>
</head>
<body>
	<h1>Hello~!</h1>
	<h1>Hello~!</h1>
	<h1>Hello~!</h1>
	
	<div>Hello~!</div>
	<div>Hello~!</div>
	<div>Hello~!</div>
	
	<span>Hello~!</span>
	<span>Hello~!</span>
	<span>Hello~!</span>
	
	<p>Hello~!</p>
	<p>Hello~!</p>
	<p>Hello~!</p>
</body>
</html>