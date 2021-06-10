<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드바 만들기</title>
<script>
	function toggleMenu(){
		var sidebar=document.querySelector(".sidebar");
		sidebar.classList.toggle("active");
	}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/design/common.css">
<style>
	.sidebar{
		background-color:yellow;
		position:fixed;
		top:0;
		left:0;
		bottom:0;
		width:250px;
		margin-left:-250px;
		transition:margin-left 0.5s linear;
	}
	.sidebar.active{
		margin-left:0px;
	}
	.sidebar-btn{
		position:fixed;
		top:10px;
		left:10px;
		font-size:30px;
	}
</style>
</head>
<body>
	<aside class="sidebar">
		<button class="sidebar-btn" onclick="toggleMenu();">&#8801;</button>	
	</aside>
</body>
</html>