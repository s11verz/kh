<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jQuery</title>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
	<style>
	
	</style>
	
<!-- 	개발할 때는 uncompressed 버전, 개발 후 배포시에는 compressed(minify) 버전을 사용 -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
	<script>
		$(function(){
			//form을 전송하려고 하면 확인창을 띄운 뒤 확인을 누른 경우만 진행
			//$(".test-form").on("submit", function(e){})
			$(".test-form").submit(function(e){
				var choice = window.confirm("정말 검색하시겠습니까?");
				if(!choice){
					e.preventDefault();//return false;
				}
			});
		});
	</script>
</head>
<body>
	<form action="test09form.jsp" class="test-form">
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</body>
</html>