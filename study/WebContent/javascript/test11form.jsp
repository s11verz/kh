<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>폼 전송 시 검사 방법</title>
	<script>
		//form은 전송 이벤트(onsubmit)를 통해서 검사를 수행한다.
		//= submit 버튼을 누르거나, 코드를 통해서 submit이 발생한 상황을 의미한다.
		//= form 내부에 있는 전송되는 입력창들을 검사하여 "올바른 형식"인지 확인해서 전송 여부를 결정해야 한다
		//= onsubmit에서 return true가 발생하면 전송, return false가 발생하면 전송 중지 처리됨		
		//= 함수를 하나 만들어서 해당 함수의 실행 결과를 return 처리하여 전송/중지를 결정
		
		function formCheck(){
			var judge = true;
			
			var idRegex = /^[a-z0-9]{8,20}$/;
			var idInput = document.querySelector("input[name=memberId]");
			if(!idRegex.test(idInput.value)){
				//var idSpan = document.querySelector("input[name=memberId] + span");
				var idSpan = idInput.nextElementSibling;
				idSpan.textContent = "아이디를 8~20자 이내의 영문 소문자, 숫자로 작성하세요";
				judge = false;
			}
			else{
				var idSpan = idInput.nextElementSibling;
				idSpan.textContent = "";
			}
			
			var pwRegex = /^[a-z0-9!@#$]{8,16}$/;
			var pwInput = document.querySelector("input[name=memberPw]");
			if(!pwRegex.test(pwInput.value)){
				var pwSpan = pwInput.nextElementSibling;
				pwSpan.textContent = "비밀번호를 8~16자 이내의 영문 소문자, 숫자, 특수문자(!@#$)로 작성하세요"
				pwInput.select();
				judge = false;
			}
			else{
				var pwSpan = pwInput.nextElementSibling;
				pwSpan.textContent = "";
			}
			
			return judge;
		}
		
	</script>
</head>
<body>
	<form action="https://www.naver.com" method="post" onsubmit="return formCheck();">
		<input type="text" name="memberId"><span></span>
		<br><br>
		<input type="text" name="memberPw"><span></span>
		<br><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>