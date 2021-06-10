<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 확대/축소</title>
<script>
	function increase(){
		var banner=document.querySelector(".banner");
		banner.width+=30;
		banner.height+=30;
	}
	function decrease(){
		var banner=document.querySelector(".banner");
		banner.width-=30;
		banner.height-=30;
	}
</script>
</head>
<body>
	<input type="button" value="확대" onclick="increase();">
	<input type="button" value="축소" onclick="decrease();">
	<hr>
	<img src="<%=request.getContextPath() %>>/image/unnamed.jpg" width="200" height="200" class="banner">
	
</body>
</html>