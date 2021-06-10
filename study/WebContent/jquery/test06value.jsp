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
	
	$(function(){
		$(".test-input").on("input",function(){
			var content=$(this).val();
			/* var text=$(this).val(); */
			/* var div1=document.querySelector(".copy-area1").innerHTML=text;
			var div2=document.querySelector(".copy-area2").innerHTML=text; */
			$(".copy-area1").html(content);
			$(".copy-area2").text(content);
		});
	});
</script>
</head>
<body>
	<textarea class="text-input"></textarea>
	<div class="copy-area1"></div>
	<div class="copy-area2"></div>
</body>
</html>