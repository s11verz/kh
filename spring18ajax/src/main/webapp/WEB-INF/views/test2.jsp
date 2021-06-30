<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap 배우기</title>

    <!-- bootstrap 이용을 위한 CSS 의존성 등록 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
		.product-item {
			border:1px solid gray;
		}
    </style>

    <!-- bootstrap 이용을 위한 JS 의존성 등록 (jQuery/popper/BS) -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    <script>
		$(function(){
// 			테스트(1) : #search-btn을 누르면 목록 조회 요청을 발생
			$("#search-btn").click(function(){
				
				$.ajax({
					url : "${pageContext.request.contextPath}/data/product/list1",
// 					url:"../data/product/list1",
// 					data:{},
					type:"get",
					dataType:"json",
					success:function(resp){
// 						console.log("성공");
// 						console.log(resp);
// 						$("#search-result").html("");
// 						$("#search-result").text("");
						$("#search-result").empty();
// 						첫 번째 방법 : 문자열로 작성하여 추가(가장 비효율적)
// 						for(var i=0; i < resp.length; i++){
							
// 							//태그 생성(문자열)
// 							var content = "";
// 							content += "<div class='row product-item'>"
// 							content += "<div class='col-4 p-2'>";
// 							content += "<img src='https://via.placeholder.com/100x100?text=P' width='100%'>";
// 							content += "</div>";
// 							content += "<div class='col-8 p-2'>";
// 							content += "<div class='row'>";
// 							content += "<div class='col-12'>";
// 							content += "<h5>"
// 							content += resp[i].name;
// 							content += "</h5>";
// 							content += "</div>";
// 							content += "</div>";
// 							content += "<div class='row'>";
// 							content += "<div class='col-12'>";
// 							content += resp[i].type;
// 							content += "</div>";
// 							content += "</div>";
// 							content += "<div class='row'>";
// 							content += "<div class='col-12'>";
// 							content += "판매가 : " + resp[i].price + "원";
// 							content += "</div>";
// 							content += "</div>";
// 							content += "</div>";
// 							content += "</div> ";
// 							content += "</div> ";
							
// 							//태그 추가
// 							$("#search-result").append(content);
// 						}
						
// 						두 번째 방법 : 태그 생성 명령을 사용
// 						= $("<div>") 로 작성하면 선택이 아니라 생성을 의미
						
// 						for(var i=0; i < resp.length; i++){
// 							//태그 생성
// 							var item = $("<div>").addClass("col-sm-6").addClass("col-md-4");
// 							var row = $("<div>").addClass("row").addClass("product-item");
// 							var leftDiv = $("<div>").addClass("col-4").addClass("p-2");
// 							var rightDiv = $("<div>").addClass("col-8").addClass("p-2");
// 							var img = $("<img>").attr("src", "https://via.placeholder.com/100x100?text=P").css("width", "100%");
// 							var rightDivInner1 = $("<div>").addClass("row");
// 							var rightDivInner2 = $("<div>").addClass("row");
// 							var rightDivInner3 = $("<div>").addClass("row");
// 							var rightDivInnerCol1 = $("<div>").addClass("col-12");
// 							var rightDivInnerCol2 = $("<div>").addClass("col-12").text(resp[i].type);
// 							var rightDivInnerCol3 = $("<div>").addClass("col-12").text("판매가 : "+resp[i].price+"원");
// 							var rightDivInnerCol1Header = $("<h5>").text(resp[i].name);
							
// 							item.append(row);
// 							row.append(leftDiv);
// 							row.append(rightDiv);
// 							leftDiv.append(img);
// 							rightDiv.append(rightDivInner1).append(rightDivInner2).append(rightDivInner3);
// 							rightDivInner1.append(rightDivInnerCol1);
// 							rightDivInnerCol1.append(rightDivInnerCol1Header);
// 							rightDivInner2.append(rightDivInnerCol2);
// 							rightDivInner3.append(rightDivInnerCol3);
							
// 							//태그 추가
// 							$("#search-result").append(item);
// 						}
// 						세 번째 방법 : 미리 준비한 template을 불러와 데이터 설정 후 추가
						for(var i=0; i < resp.length; i++){
							var template = $("#list-item-template").html();
							template = template.replace("{{name}}", resp[i].name);
							template = template.replace("{{type}}", resp[i].type);
							template = template.replace("{{price}}", resp[i].price);
							$("#search-result").append(template);
						}
					},
				});
				
			});
			
			
// 			테스트(2) : #search-btn2을 누르면 이름 검색 요청을 발생
// 			$("#search-btn2").click(function(){
// 				//입력값 불러오기
// 				var name = $("input[name=name]").val();
// 				if(!name){//name.length == 0
// 					return;
// 				}
				
// 				$.ajax({
// 					url:"${pageContext.request.contextPath}/data/product/list2",
// 					type:"get",
// 					dataType:"json",
// 					data:{name:name},
// 					success:function(resp){
// 						$("#search-result").empty();
// 						for(var i=0; i < resp.length; i++){
// 							var template = $("#list-item-template").html();
// 							template = template.replace("{{name}}", resp[i].name);
// 							template = template.replace("{{type}}", resp[i].type);
// 							template = template.replace("{{price}}", resp[i].price);
// 							$("#search-result").append(template);
// 						}
// 					}
// 				});
// 			});
	
// 			테스트(3) : #name-search-form을 전송하면 폼정보를 이용한 검색 요청을 발생
			$("#name-search-form").submit(function(e){
				e.preventDefault();				
				
				//폼 입력값을 전송 가능한 형태로 불러오기
				//= serialize()는 form에 입력된 데이터를 Query String 으로 변환하는 명령
				var formdata = $(this).serialize();
				console.log(formdata);
				
				$.ajax({
					url:"${pageContext.request.contextPath}/data/product/list2",
					type:"get",
					dataType:"json",
					data:formdata,
					success:function(resp){
						$("#search-result").empty();
						for(var i=0; i < resp.length; i++){
							var template = $("#list-item-template").html();
							template = template.replace("{{name}}", resp[i].name);
							template = template.replace("{{type}}", resp[i].type);
							template = template.replace("{{price}}", resp[i].price);
							$("#search-result").append(template);
						}
					}
				});
			});
		});
    </script>
    
    <!-- 
    	목표 : 비동기 통신 등에서 사용할 화면 조각들을 "템플릿"으로 보관하고 싶다
    	
    	= script 영역을 만들고 type을 "text/template"으로 지정하면 템플릿 문자열로 인식
    	= script 영역에 id를 부여하여 불러와서 사용한다.
     -->
    <script id="list-item-template" type="text/template">
    	<div class="col-md-4 col-sm-6">
			<div class="row product-item">
				<div class="col-4 p-2">
					<img src="https://via.placeholder.com/100x100?text=P" width="100%">
				</div>
				<div class="col-8 p-2">
					<div class="row">
						<div class="col-12">
							<h5>{{name}}</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-12">{{type}}</div>
					</div>
					<div class="row">
						<div class="col-12">판매가 : {{price}}원</div>
					</div>
				</div>
			</div> 
		</div>
    </script>

</head>
<body>
    
    <!-- 컨테이너 시작 -->
    <div class="container-fluid">
    
    	<!-- 점보트론 시작 -->
    	<div class="jumbotron text-center mt-3">
    		<h1>상품 찾아보기</h1>
    	</div>
    	<!-- 점보트론 종료 -->
    	
    	<!-- 검색화면 시작 -->
    	
    	<!-- [1] 단순 목록 조회 -->
    	<div class="row">
    		<div class="col-md-10">
    			<button id="search-btn" class="btn btn-outline-primary">조회</button>
    		</div>
    	</div>
    	
    	<!-- [2] 이름을 이용하여 상품 검색 -->
    	<div class="row mt-3">
    		<div class="col-md-10">
    			<form id="name-search-form" class="form-inline">
    				<div class="form-group">
	    				<input type="text" name="name" class="form-control">
    				</div>
    				<div class="form-group">
    					<button type="submit" id="search-btn2" class="btn btn-outline-primary">검색</button>
    				</div>
    			</form>
    		</div>
    	</div>
    	
    	<!-- 검색화면 종료 -->
    	
    	<!-- 검색결과 시작 -->
    	<div class="row mt-5" id="search-result">
    		
    	</div>    	
    	<!-- 검색결과 종료 -->
    	
    </div>
    <!-- 컨테이너 종료 -->
    
</body>
</html>


