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
			//목표 : 전체선택을 하면 모든 항목의 체크에 영향을 미치도록 구현
			//.attr() : attribute를 확인하는 명령. 태그에 적힌 속성값을 글자로 반환. 확인/변경 가능
			//.prop() : property를 확인하는 명령. 태그의 내부 속성을 형태에 맞게 반환. 확인/변경 가능
			//.is() : css의 상태선택자를 이용하여 상태를 확인하는 명령. 확인만 가능하고 변경은 불가
			$(".check-all").on("input", function(){
				//console.log(this.checked);
				
				//console.log("attr = " + $(this).attr("checked"));
				//console.log("prop = " + $(this).prop("checked"));
				//console.log("is = " + $(this).is(":checked"));
				
				//$(".check-item").attr("checked", "checked");
				//$(".check-item").prop("checked", true);
				
				var current = $(this).prop("checked");
				$(".check-item").prop("checked", current);
				$(".check-all").prop("checked", current);
			});
		});
	</script>
</head>
<body>
	<input type="checkbox" class="check-all"> 전체선택
	<hr>
	<input type="checkbox" class="check-item"> 항목1 <br>
	<input type="checkbox" class="check-item"> 항목2 <br>
	<input type="checkbox" class="check-item"> 항목3 <br>
	<input type="checkbox" class="check-item"> 항목4 <br>
	<input type="checkbox" class="check-item"> 항목5 <br>
	<hr>
	<input type="checkbox" class="check-all"> 전체선택
</body>
</html>