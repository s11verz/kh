<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<button id="bt1">동기요청</button>
<button id="bt2">비동기요청</button>
<div id="result"></div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//동기요청 버튼을 누르면 /data/test1로 이동 
		$("#bt1").click(function(){
			//location.href="http://localhost8080/spring18/data/test1";
			//location.href="${pageContext.request.contextPath}/data/test1";
			location.href="../data/test1";
		});
		
		//비동기요청 버튼을 누르면 /data/test1의 내용을 가져옴 
		$("#bt2").click(function(){
			$.ajax({
				url:"../data/test1",
				success:function(resp){
					$("#result").html(resp);
				}
			});
		});
	});
</script>

<hr>

<h3>비동기 통신을 이용한 더하기 구현</h3>

<input type="text" name="a">
+
<input type="text" name="b">
<button id="equal">=</button>
<span id="c"></span>

<script>
	$(function(){
		//equal이라는 아이디를 가진 버튼을 클릭하면 비동기통신으로 요청을 보낸 결과를 화면에 출력 
		//단, 요청에 a와 b라는 이름의 데이터를 첨부해야 함 
		$("#equal").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/data/test2",
				data:{
					a:$("input[name=a]").val(),
					b:$("input[name=b]").val()
				},
				success:function(resp){
					$("#c").text(resp);
				}
			});
		});
	});
</script>

<hr>

<h1>비통기통신을 이용한 아이디 중복 확인</h1>

<input type="text" name="memberId">
<span></span>

<script>
$(function(){
	//아이디 입력창의 input/blur 시점에 비동기통신을 이용하여 화면을 유지한 채로 아이디 중복검사 수행
	$("input[name=memberId]").blur(function(){
		//this : 입력창
		var memberId = $(this).val();
		
		$.ajax({
			url:"${pageContext.request.contextPath}/data/test3",
			data:{
				memberId : memberId
			},
			type:"post",
			success:function(resp){//"Y"는 사용가능, "N"은 사용중으로 처리
				if(resp === "Y") {
					$("input[name=memberId] + span").text("사용 가능한 아이디입니다");
				}
				else if(resp === "N"){
					$("input[name=memberId] + span").text("이미 사용중인 아이디입니다");
				}
			}
		});
		
	});		
});
</script>

<hr>

<h1>비동기통신을 이용한 회원목록/검색</h1>

<button id="list">목록보기</button>

<div id="list-result"></div>

<script>
	$(function(){
		$("#list").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/data/test4",
				type:"get",
				success:function(resp){
					//console.log(resp);
					
					//resp는 객체 배열이므로 반복해가며 코드를 생성해야함
					$("#list-result").empty();
					for(var i=0; i < resp.length; i++){
						$("#list-result").append("<h3>"+resp[i].memberId+"</h3>");
					}
				},
				error:function(){
					$("#list-result").text("불러오기 오류 발생");
				},
				complete:function(){
					
				}
			});
		});
	});
</script>






























