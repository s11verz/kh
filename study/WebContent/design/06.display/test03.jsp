<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
/*
ul:순서가 없는 리스트
ol:순서가 있는 리스트
li:리스트 안에 들어가는 항목
*/
.pagination-list {
			list-style: none;
			margin:0px;
			padding:0px;
		}
		.pagination-list > li {
			display: inline-block;
			min-width: 35px;
			
			border:1px solid transparent;
			padding:0.5rem;
			text-align:center;
			cursor: pointer;
		}
		.pagination-list > li > a {
			color:gray;
			text-decoration: none;
		}
		.pagination-list > li:hover,
		.pagination-list > li.on {
			border:1px solid lightgray;
		}
		.pagination-list > li:hover > a,
		.pagination-list > li.on > a {
			color:rgb(255,85,146);
		}
</style>
</head>
<body>

	<ol class="pagination-list">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li class="on"><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">6</a></li>
		<li><a href="#">7</a></li>
		<li><a href="#">8</a></li>
		<li><a href="#">9</a></li>
		<li><a href="#">10</a></li>
	</ol>
</body>
</html>