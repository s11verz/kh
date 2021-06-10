<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Layout 적용하기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	main,aside,section,article,header,footer{
		border:1px solid black;
	}
	html,body{
		margin:0;
		padding:0;
	}
	main{
		width:1200px;
		margin:auto;
	}
	main::after{
		content:"";
		display:block;
		clear:both;
	}
	aside{
		float:left;
		width:20%;
		min-height:500px;
	}
	section{
		float:left;
		width:80%;
		min-height:500px;
	}
	header{
		min-height:100px;
	}
	article{
		min-height:300px;
	}
	footer{
		min-height:100px;
	}
	
</style>
</head>
<body>
<main>
	<aside></aside>
	
		<section>
			<header></header>
			<article></article>
			<footer></footer>
		</section>
</main>
</body>
</html>