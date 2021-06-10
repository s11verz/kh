<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>함수 응용</title>
	<script>
		//자바스크립트는 함수를 만드는 방식이 2가지
		//1. 함수 선언식 : 위치와 무관하게 호출 가능한 함수를 만드는 방식
		function test1(){
			console.log("test1 함수 실행");
		}
		
		//2. 함수 표현식 : 변수처럼 선언 이후에만 사용할 수 있도록 만드는 방식
		var test2 = function(){
			console.log("test2 함수 실행");
		};
		
		test1();
		test2();
		
		//함수를 변수처럼 취급할 수 있다는 것은, 매개변수에 함수가 들어갈 수 있다는 소리!
		function test3(fn){
			console.log("test3 함수 실행 시작");
			fn();
			console.log("test3 함수 실행 종료");
		}
		
		test3(test2);//test3을 실행하면서 test2 함수 정보를 전달(call-back 방식. 예약 실행)
		
		test3(function(){
			console.log("익명 함수 실행!");
		});
	</script>
</head>
<body>

</body>
</html>