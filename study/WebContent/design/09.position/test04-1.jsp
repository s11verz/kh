<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 만들기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.menu,.menu ul{
		margin:0;
		padding:0;
		list-style:none;
		background-color:lightgray;
		
	}
	.menu>li{
		display:inline-block;
		position:relative;
	}
	.menu ul{
		display:none;
		position:absolute;
		left:0;
		top:53px;
	}
	.menu li:hover>ul{
		display:block;
	}
	.menu li{
		padding:1rem;
		width:150px;
	}
	.menu li:hover{
		background-color:silver;
	}
	.menu>li a{
		color:white;
		text-decoration:none;
	}
</style>
</head>
<body>
	<ul class="menu">
		<li>
			<a href="#">메뉴1</a>
			<ul>
				<li><a href="#">서브1</a></li>
				<li><a href="#">서브2</a></li>
				<li><a href="#">서브3</a></li>
				<li><a href="#">서브4</a></li>
			</ul>
		</li>
		<li>
			<a href="#">메뉴2</a>
			<ul>
				<li><a href="#">서브1</a></li>
				<li><a href="#">서브2</a></li>
				<li><a href="#">서브3</a></li>
				<li><a href="#">서브4</a></li>
			</ul>
		</li>
		<li>
			<a href="#">메뉴3</a>
			<ul>
				<li><a href="#">서브1</a></li>
				<li><a href="#">서브2</a></li>
				<li><a href="#">서브3</a></li>
				<li><a href="#">서브4</a></li>
			</ul>
		</li>
		<li>
			<a href="#">메뉴4</a>
			<ul>
				<li><a href="#">서브1</a></li>
				<li><a href="#">서브2</a></li>
				<li><a href="#">서브3</a></li>
				<li><a href="#">서브4</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>