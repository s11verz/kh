<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Javascript 객체 다루기</title>
	<script>
		//자바스크립트에서 객체는 "복잡한 데이터"를 말한다
		//= 배열, 객체 등을 모두 포함한다
		
		//1. 배열 : 정적 배열, 동적 배열 - 배열의 크기가 가변이다(자바로 치면 List에 가깝다)
		//= 정적 배열 : 데이터를 정해놓고 시작하는 배열(10, 20, 30, 40, 50을 저장하겠다)
		var a = [10, 20, 30, 40, 50];
		console.log(a);
		
		for(var i=0; i < a.length; i++){
			console.log(a[i]);
		}
		
		//= 동적 배열 : 크기만 정해놓고 시작하는 배열(5개의 데이터를 저장하겠다)
		//= 자바에서는 int[] b = new int[5]; 형태로 만든다
		var b = new Array(5);
		console.log(b);
		
		b[1] = 20;
		for(var i=0; i < b.length; i++){
			console.log(b[i]);
		}
		
		//정적 배열을 이용한 데이터 추가
		var c = [];
		c.push(10);
		c.push(20);
		c.push(30);
		c.push(40);
		c.push(50);
		console.log(c); 
		
		var d = [];
		d[0] = 10;
		d[1] = 20;
		d[2] = 30;
		d[3] = 40;
		d[4] = 50;
		console.log(d);
		
		//2. 객체 : 정적 객체, 동적 객체
		//= 정적 객체 : 객체 생성을 위한 준비 없이 바로 변수와 데이터를 설정하며 만드는 객체
		var e = {
				name : "홍길동", 
				score : 79
		};
		console.log(e);
		console.log(e.name);//이름 출력 
		console.log(e["name"]);
		console.log(e.score);//점수 출력
		console.log(e["score"]);
		
		//= 동적 객체 : 객체 생성을 위한 준비(생성자 함수) 수행 후 new를 이용하여 만드는 객체
		//		= 자바스크립트는 클래스가 없고, 접근 제한도 없다
		//		= 생성에 필요한 최소한의 정보만 함수로 만들어서 "생성자 함수"라고 부른다(자바의 생성자와 동일)
		//		= this : 객체 자신(주인공) 
		function Student(name, score){
			this.name = name;
			this.score = score;
		};
		
		var f = new Student("피카츄", 50);
		var g = new Student("라이츄", 60);
		console.log(f);
		console.log(g);
	</script>
</head>
<body>
	
</body>
</html>





