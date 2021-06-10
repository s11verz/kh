<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Github : Where the world builds software</title>
	<link rel="stylesheet" type="text/css" href="/study/design/common.css">
	<style>
		div{
/* 			border:1px dotted black; */
		}
		
		.float-container > .left {
			float:left;
		}
		.float-container > .right {
			float:right;
		}
		
		.float-container{
			padding:15px;
		}
		
		.float-container a {
			margin-left:0.5rem;
			padding-top:0.5rem;
			padding-bottom:0.5rem;
			display:inline-block;
			text-decoration: none;
			color:gray;
		}
		.float-container a:hover{
			color:red;
		}
	</style>
</head>
<body>
	<div class="float-container">
		<div class="left">
			<img alt="로고이미지" src="https://via.placeholder.com/30x30?text=G">
		</div>
		<div class="left">
		<ul class="pagination-list">
			<li><a href="#">Why GitHub?</a></li>
			<li><a href="#">Team</a></li>
			<li><a href="#">Enterprise</a></li>
			<li><a href="#">Explore</a></li>
			<li><a href="#">Marketplace</a></li>
			<li><a href="#">Pricing</a></li>
			</ul>
		</div>
		<div class="right">
			<a href="#">Sign In</a>
			<a href="#">Sign Up</a>
		</div>
		<div class="right">
			<form action="?" method="get">
				<input type="text" placeholder="Search Github" class="form-input form-input-inline">
				<input type="submit" value="검색" class="form-btn form-btn-inline">
			</form>
		</div>
	</div>
</body>
</html>