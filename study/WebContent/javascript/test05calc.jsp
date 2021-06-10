<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리가 만들고 싶은 화면</title>
<script>
	function test(){
	var a=document.querySelector("input[name=a]");
	var b=document.querySelector("input[name=b]");
	var c=document.querySelector("input[name=c]");
	
	c.value=parseInt(a.value)+parseInt(b.value);
	}
</script>
</head>
<body>
	<input type="text" name="a" class="a">
	+
	<input type="text" name="b" class="b">
	
	<input type="button" value="=" onclick="test();">
	<input type="text" name="c" class="c">
</body>
</html>