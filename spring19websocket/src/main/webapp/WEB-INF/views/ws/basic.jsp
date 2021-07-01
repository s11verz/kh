<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>BasicServer 연결 예제</h1>

<button id="connect">연결</button>
<button id="disconnect">종료</button>

<input type="text" id="user-input">
<button id="send">전송</button>

<!-- 메세지 출력 영역 -->
<div id="message-area"></div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//목표 : 준비한 WebSocketBasicServer에 접속 및 종료할 수 있는 JS 코드 작성
		//= Javascript에 내장된 WebSocket API 를 사용
		
		$("#connect").click(function(){
			var uri = "ws://localhost:8080/spring19/basic";
			window.socket = new WebSocket(uri);
			
			//생성 이후에 할 일(코드)들을 예약작업으로 설정 - callback 함수 설정
			//= arguments는 사용 가능한 매개변수를 모두 보여준다.
			console.log(window.socket);
			window.socket.onopen = function(){
				//console.log(arguments);
				$("#connect").prop("disabled", true);
				$("#disconnect").prop("disabled", false);
				$("#user-input").prop("disabled", false);
				$("#send").prop("disabled", false);
			};
			window.socket.onclose = function(){
				//console.log(arguments);
				$("#connect").prop("disabled", false);
				$("#disconnect").prop("disabled", true);
				$("#user-input").prop("disabled", true);
				$("#send").prop("disabled", true);
			};
			window.socket.onerror = function(){
				//console.log(arguments);
			};
			window.socket.onmessage = function(message){
				//console.log(arguments);
				//console.log(arguments[0].data);
				//console.log(message.data);
				var tag = $("<p>").text(message.data);
				$("#message-area").append(tag);
				$("#user-input").val("");
			};
		});
	
		$("#disconnect").click(function(){
			if(!window.socket) return;
			window.socket.close();
		});
		
		$("#send").click(function(){
			if(!window.socket) return;
			
			var text = $("#user-input").val();
			if(!text) return;
			
			window.socket.send(text);
		});
		
		//추가 : 버튼 비활성화
		$("#disconnect").prop("disabled", true);//처음에 종료버튼 비활성화
		$("#user-input").prop("disabled", true);
		$("#send").prop("disabled", true);
	});
</script>




