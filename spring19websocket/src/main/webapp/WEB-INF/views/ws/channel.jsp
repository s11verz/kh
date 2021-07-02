<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>ChannelServer 연결 예제 (현재 채널 : ${channel})</h1>

<input type="text" id="user-input">
<button id="send">전송</button>

<hr>

<!-- 메세지 출력 영역 -->
<div id="message-area"></div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//목표 : 준비한 WebSocketBasicServer에 접속 및 종료할 수 있는 JS 코드 작성
		//= Javascript에 내장된 WebSocket API 를 사용
		var uri = "ws://localhost:8080/spring19/channel";
		window.socket = new WebSocket(uri);
		
		//생성 이후에 할 일(코드)들을 예약작업으로 설정 - callback 함수 설정
		//= arguments는 사용 가능한 매개변수를 모두 보여준다.
		console.log(window.socket);
		window.socket.onopen = function(){
			//연결이 되면 바로 서버에게 채널 접속 메세지를 전송해야 한다.
			//{"type":1 , "channel": "hello"} 형태로 전송
			var message = {type:1, channel:"${channel}"};
			var json = JSON.stringify(message);
			window.socket.send(json);
		};
		window.socket.onclose = function(){
			//console.log(arguments);
		};
		window.socket.onerror = function(){
			//console.log(arguments);
		};
		window.socket.onmessage = function(message){
			//console.log(arguments);
			//console.log(arguments[0].data);
			//console.log(message.data);
			//console.log(typeof message.data);
			
			var messageObject = JSON.parse(message.data);//String --> JSON Object
			console.log(messageObject);
			
			var user = $("<span>").css("font-size", "1.3rem").text("["+messageObject.memberNick+"]");
			var content = $("<span>").text(messageObject.message);
			var tag = $("<div>");
			
			tag.append(user).append(content);
			$("#message-area").append(tag);
			
			$("#user-input").val("");
		};
	
		$("#send").click(function(){
			if(!window.socket) return;
			
			//보낼 때 서버에서 이해할 수 있는 양식으로 보내야 한다
			//{"type":2 , "channel": "hello" , "content" : "안녕하세요" }
			var text = $("#user-input").val();
			if(!text) return;
			
			var message = {type:2, channel:"${channel}", content:text};
			var json = JSON.stringify(message);			
			window.socket.send(json);
		});
		
	});
	
	//beforeunload 이벤트는 화면이 로딩 해제되기 직전에 실행된다.
	//= 웹소켓 서버에 저 나가요~ 라는 메세지를 이곳에서 보낼 예정
	$(window).on("beforeunload", function(){
		if(!window.socket) return;
		
		var message = {type:3, channel:"${channel}"};
		var json = JSON.stringify(message);
		window.socket.send(json);
	});
</script>



