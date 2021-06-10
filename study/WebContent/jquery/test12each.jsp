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
// 			목표 : 홀수번째는 빨강, 짝수번째는 파랑으로 글자색을 설정
// 			$("h1:nth-child(2n)").css("color", "blue");
// 			$("h1:nth-child(2n-1)").css("color", "red");
//				jQuery 전용 반복문을 통해 쉽게 요소들의 정보를 획득
//				= index : 현재 반복중인 순서
//				= data : 현재 반복중인 태그(== this)
// 			방법1 : 태그 선택 후 each 사용
			$("h1").each(function(index, data){
				if(index % 2 != 0){
					$(this).css("color", "red");					
				}
				else{
					$(this).css("color", "blue");
				}
			});
			
// 			방법2 : each 명령에 태그를 넣는 방법
			$.each($("h1"), function(index, data){
				if(index % 2 != 0){
					$(this).css("background-color", "gray");					
				}
				else{
					$(this).css("background-color", "yellow");
				}
			});
		});	
	</script>
</head>
<body>
	
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	<h1>Hello jQuery!</h1>
	
</body>
</html>