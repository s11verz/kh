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
		//property는 기본적으로 제공되는 속성만 읽을 수 있다.
		//attribute는 작성된 글자를 읽을 수 있다.
		$(function(){
			console.log($("body").prop("test"));
			console.log($("body").attr("test"));
			
			$(".qty").on("input", function(){
				var count = $(this).val();
// 				var price = $(this).prop("data-price");//불가
// 				var price = $(this).attr("data-price");//가능
				var price = $(this).data("price");//data- 전용 명령
				
				var total = parseInt(count) * parseInt(price);
				$(".res").text(total);
			});
		});
	</script>
</head>
<body test>
	
	수량 : <input type="number" class="qty" data-price="15000"> 총 <span class="res">0</span>원
	
</body>
</html>