<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>다중 컴포넌트 제어</title>
	<script>
		window.addEventListener("load", function(){
			//1. 전체 선택 버튼을 누르면 모든 체크박스가 선택되도록 구현
			//= 한 번에 모든 체크박스를 선택하여 체크하는 방법
			//= document.querySelectorAll() ---> 결과물이 배열
			document.querySelector(".check-all").addEventListener("click", function(){
				var checkbox = document.querySelectorAll(".check-item");
				console.log(checkbox);
				
				checkbox[0].checked = true;
				checkbox[1].checked = true;
				checkbox[2].checked = true;
			});			
		});
	</script>
</head>
<body>
	<button class="check-all">전체 선택</button>
	<hr>
	<input type="checkbox" class="check-item" id="c1"><label>사과</label>
	<input type="checkbox" class="check-item" id="c2"><label>바나나</label>
	<input type="checkbox" class="check-item" id="c3"><label>파인애플</label>
</body>
</html>