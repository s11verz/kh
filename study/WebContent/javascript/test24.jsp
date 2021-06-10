<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>체크박스 다루기</title>
	<script>
		//체크박스 제어
		//목표 : 동의를 해야만 다음 단계로 진행 버튼이 활성화되도록 구현
		window.addEventListener("load", function(){
			var checkbox = document.querySelector("#agree");
			checkbox.addEventListener("input", function(){
				//주인공(this) == 체크박스
				//console.log(this.checked);
				
				var nextBtn = document.querySelector("#next-btn");
				if(this.checked){//체크가 되었다면
					nextBtn.disabled = false;
				}
				else{
					nextBtn.disabled = true;
				}
			});
		});
	</script>
</head>
<body>
	<input type="checkbox" id="agree"> 
	<label for="agree">동의합니다</label>
	
	<hr>
	
	<input type="button" value="다음 단계로 진행" id="next-btn" disabled>
</body>
</html>